package dao;

import domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudent(Student student);

    Integer insertStudent(Student student);
}
