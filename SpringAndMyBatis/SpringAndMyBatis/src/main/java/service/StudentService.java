package service;

import domain.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    List<Student> selectStudent(Student student);
}
