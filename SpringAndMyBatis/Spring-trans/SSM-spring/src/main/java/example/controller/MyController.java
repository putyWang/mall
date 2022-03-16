package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MyController {
    static{
        System.out.println("Mycontroller创建了");
    }
/*
*   请求参数地址do.some
*   请求方法：get方法
* */
    @RequestMapping("/some.do")
    public ModelAndView doSome(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @RequestMapping(value="/other.do")
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}
