package generator.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import generator.domain.Student;
import generator.service.StudentService;
import generator.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author 小哥哥
* @description 针对表【student】的数据库操作Service实现
* @createDate 2022-02-20 12:46:07
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
implements StudentService{

}
