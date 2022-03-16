package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.Until;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs =null;
        try {
            conn = Until.getConnection();
            st = conn.prepareStatement("select id,dname,loc from MysqlTest");
            rs = st.executeQuery();
//            out.print("<!DOCTYPE html>");
//            out.print("<html>");
//            out.print("	<head>");
//            out.print("		<meta charset='utf-8'>");
//            out.print("		<title>部门列表页面</title>");
//            out.print("	</head>");
//            out.print("	<body>");
//            out.print("		<h1 align = 'center'>部门列表</h1>");
//            out.print("		<hr>");
//            out.print("		<table border='1px' align = 'center' width='50%'>");
//            out.print("			<tr>");
//            out.print("				<th>序号</th>");
//            out.print("				<th>部门编号</th>");
//            out.print("				<th>部门名称</th>");
//            out.print("				<th>地址</th>");
//            out.print("				<th>操作</th>");
//            out.print("			</tr>");

//            int i = 0;
            while(rs.next()){
                out.print(rs.getString("id") + rs.getString("dname") + rs.getString("loc") + '\n');
//                out.print("			<tr>");
//                out.print("				<td>"+ (++i) +"</td>");
//                out.print("				<td>" + rs.getString("id") + "</td>");
//                out.print("				<td>"+rs.getString("dname")+"</td>");
//                out.print("				<td>"+ rs.getString("loc") +"</td>");
//                out.print("				<td>");
//                out.print("					<a href=''>删除</a>");
//                out.print("					<a href='edit.html'>修改</a>");
//                out.print("					<a href='detail.html'>详情</a>");
//                out.print("				</td>");
//                out.print("			</tr>");
            }


//        out.print("		</table>");
//        out.print("		<hr>");
//        out.print("		<a href='add.html'>新增部门</a>");
//        out.print("	</body>");
//        out.print("</html>");


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Until.close(conn,st,rs);
        }
    }
}
