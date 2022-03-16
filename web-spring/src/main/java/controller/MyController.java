package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @RequestMapping("/some.do")
    public String doSome(HttpServletRequest request, String name, Integer age){
        request.setAttribute("name",name);
        request.setAttribute("age",age);
        return "Result";
    }
}
