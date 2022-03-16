package service.impl;

import dao.StudentDao;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.StudentService;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {

        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> selectStudent(Student student) {

        return studentDao.selectStudent(student);
    }

    @Override
    public String toString() {
        return "StudentServiceImpl{" +
                "studentDao=" + studentDao +
                '}';
    }
}
