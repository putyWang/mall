package com.bjpowernode.sms.dao;

import com.bjpowernode.sms.beans.Student;

public interface IStudentDao {
    Student selectStudentLogin(String num, String password);
    int saveStudent(Student student);
}
