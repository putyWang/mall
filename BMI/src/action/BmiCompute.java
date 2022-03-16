package action;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BmiCompute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        double heigth = Double.parseDouble(request.getParameter("height"));
        double weigth = Double.parseDouble(request.getParameter("weight"));
        double BMI = weigth / ( heigth * heigth );
        String result = "您的体重超重";

        if(BMI < 18.5)
            result = "体重过轻";
        else if (BMI < 22.9)
            result = "体重正常";
        else if (BMI < 24.9)
            result = "体重过重";
        else if (BMI <29.9)
            result = "您有点肥胖";

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("亲爱的" + name + "先生/女士；您的bmi值为" + BMI + "," + result);
    }
}
