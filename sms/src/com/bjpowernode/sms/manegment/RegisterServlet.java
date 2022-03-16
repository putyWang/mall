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

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        获取表单参数
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        String num = request.getParameter("num");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int score = Integer.parseInt(request.getParameter("score"));
//        创建student对象
        Student student = new Student(id , password , num , name , age , score);
//        创建Service对象
        IStudentService service = new StudentServiceImpl();
//        调用Service对象的saveStudent（）方法写入对象
        int i = service.saveStudent(student);
//        写入失败，从定向注册
        if(i == 0){
            session.setAttribute("message","注册失败，请重新注册");
            response.sendRedirect(getServletContext().getContextPath() + "/register.jsp");
        }
//        写入成功跳转到登录页面

        if(i == 1)
            response.sendRedirect(getServletContext().getContextPath() + "/login.jsp");
    }
}
