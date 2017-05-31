package servletclass;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class login extends HttpServlet
{
protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
{
	boolean st=false;
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/registration","root","roshan");
	PreparedStatement ps=con.prepareStatement("select * from p_info where UID=? and DOB=?");
	ps.setString(1,id);
	ps.setString(2,pass);
	ResultSet rs= ps.executeQuery();
	st=rs.next();
	}catch(Exception e){out.println(e);}
	if(st==true)
	{
		HttpSession session=request.getSession();  
        	session.setAttribute("id",id); 
		session.setAttribute("pass",pass); 
		RequestDispatcher rs=request.getRequestDispatcher("/info");
		rs.include(request,response);
	}
	else
	{
		out.println("Password or Email is Incorrect\n");
		RequestDispatcher rs=request.getRequestDispatcher("index.html");
		rs.include(request,response);
	}
}
}