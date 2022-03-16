package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyDao {
    public Student selectStudent(Student student);

    public Integer insertStudent(Student student);
}
