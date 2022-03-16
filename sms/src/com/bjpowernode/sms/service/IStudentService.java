package com.bjpowernode.sms.service;

import com.bjpowernode.sms.beans.Student;

public interface IStudentService {

//  用户名密码验证
    Student checkUser(String num,String password);

//  注册学生信息
    int saveStudent(Student student);
}
