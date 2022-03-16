package dubboconsumer.consumer.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import parent.service.StudentService;
import parent.vo.Student;

@RestController
public class ConsumerController {

    /*
    * 引用远程服务，将创建好的代理对象，诸如给studentService
    * */
    @DubboReference(interfaceClass = StudentService.class,version = "1.0")
    private StudentService studentService;

    @GetMapping("/query")
    public String queryStudent(){
        Student student = new Student();
        student = studentService.findStudent();
        return "调用远程接口，获取对象" + student;
    }
}
