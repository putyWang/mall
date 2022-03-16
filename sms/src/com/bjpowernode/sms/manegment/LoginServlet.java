package com.bjpowernode.sms.manegment;

import com.bjpowernode.sms.beans.Student;
import com.bjpowernode.sms.service.IStudentService;
import com.bjpowernode.sms.service.StudentServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//      接受请求数据
        String num = request.getParameter("num");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
//      判断学号与密码是否合法
        if(num == null||"".equals(num.trim())){
            session.setAttribute("message","学号输入有误");
            response.sendRedirect(getServletContext().getContextPath() + "/login.jsp");
            return;
        }

        if(password == null||"".equals(password.trim())){
            session.setAttribute("message","密码输入有误");
            response.sendRedirect(getServletContext().getContextPath() + "/login.jsp");
            return;
        }


//      创建Service对象
        IStudentService service = new StudentServiceImpl();

//      调用Service对象的checkStudent（）方法对账号密码进行验证；
        Student student = service.checkUser(num,password);
//      验证通过，则跳转到系统主页
        if (student != null)
            response.sendRedirect(getServletContext().getContextPath() + "/welcome.jsp");


//      验证未通过，则跳转到用户登录页面，同时提示密码错误；
        if (student == null){
            session.setAttribute("message","用户名或密码输入有误");
            response.sendRedirect(getServletContext().getContextPath() + "/login.jsp");
        }
    }
}
