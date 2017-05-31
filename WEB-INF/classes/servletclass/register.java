package servletclass;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class register extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
{
	boolean st=false;
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String firstname=request.getParameter("firstname");
	String lastname=request.getParameter("lastname");
	String fname=  request.getParameter("f_name");
	String lname=request.getParameter("l_name");
	String uid=request.getParameter("uid");
	String course=request.getParameter("Course");
	String class_10=  request.getParameter("CGPA_10");
	String class_12=request.getParameter("CGPA_12");
	fname=fname.concat(" ");
	fname=fname.concat(lname);
	String name=firstname.concat(" ");
	name=name.concat(lastname);
	String phone=request.getParameter("phone");
	String email=request.getParameter("email");
	String gender=request.getParameter("gender");
	String pin=request.getParameter("pin");
	String address_1=request.getParameter("address_1");
	address_1=address_1.concat(" ");
	String address_2=request.getParameter("address_2");
	String address=address_1.concat(address_2);
	String country=request.getParameter("country");
	String state=request.getParameter("state");
	String d_day=request.getParameter("day");
	d_day=d_day.concat("/");
	String d_month=request.getParameter("month");
	d_month=d_month.concat("/");
	String d_year=request.getParameter("year");
	String dob=d_day.concat(d_month);
	dob=dob.concat(d_year);
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/registration","root","roshan");
		PreparedStatement ps=con.prepareStatement("insert into p_info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,name);
		ps.setString(2,gender);
		ps.setString(3,dob);
		ps.setString(4,fname);
		ps.setString(5,email);
		ps.setString(6,phone);
		ps.setString(7,address);
		ps.setString(8,state);
		ps.setString(9,country);
		ps.setString(10,pin);
		ps.setString(11,uid);
		ps.setString(12,class_10);
		ps.setString(13,class_12);
		ps.setString(14,course);
		int k=ps.executeUpdate();
		if(k>0)
		{
		HttpSession session=request.getSession();  
        	session.setAttribute("id",uid); 
		session.setAttribute("pass",dob); 
		RequestDispatcher rs = request.getRequestDispatcher("thanks.html");
		rs.include(request, response);
		}
	}catch (Exception e2) {System.out.println(e2);}
	out.close();
}
}