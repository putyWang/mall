package com.bjpowernode.sms.dao;

import com.bjpowernode.sms.beans.Student;
import com.bjpowernode.sms.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements IStudentDao{
    @Override
    public Student selectStudentLogin(String num, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from student where num = ? and password = ?";
        Student student = null;

        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,num);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while(rs.next()){
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setNum(num);
                student.setPassWord(password);
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setScore(rs.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return student;
    }

    @Override
    public int saveStudent(Student student) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into student(id ,password,num,name,age,score) values (?,?,?,?,?,?)";
        int count = 0;
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,student.getId());
            ps.setString(2,student.getPassWord());
            ps.setString(3,student.getNum());
            ps.setString(4,student.getName());
            ps.setInt(5,student.getAge());
            ps.setInt(6,student.getScore());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(conn,ps,null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}
