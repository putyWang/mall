package com.bjpowernode.sms.service;

import com.bjpowernode.sms.beans.Student;
import com.bjpowernode.sms.dao.IStudentDao;
import com.bjpowernode.sms.dao.StudentDaoImpl;

public class StudentServiceImpl implements IStudentService{
    private IStudentDao dao;

    public StudentServiceImpl() {
        dao = new StudentDaoImpl();
    }

    @Override
    public Student checkUser(String num, String password) {
        return dao.selectStudentLogin(num,password);
    }

    @Override
    public int saveStudent(Student student) {
        return dao.saveStudent(student);
    }
}
