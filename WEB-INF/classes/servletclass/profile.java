package servletclass;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class profile extends HttpServlet
{
protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
{
	boolean st=false;
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	HttpSession session=request.getSession(false);  
        if(session!=null)
	{  
        
	String id=(String)session.getAttribute("id");  
        String pass=(String)session.getAttribute("pass");

try{

	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/registration","root","roshan");
	PreparedStatement ps=con.prepareStatement("select * from p_info where UID=? and DOB=?");
	ps.setString(1,id);
	ps.setString(2,pass);
	ResultSet rs= ps.executeQuery();
	ResultSetMetaData rsmd=rs.getMetaData();
		out.println("Welcome "+id);
		out.print("<table width=25% border=1>");
        	out.print("<center><h1>Result:</h1></center>");
		 while(rs.next())
                        {
			out.print("<tr>");
                     	out.print("<td>"+rsmd.getColumnName(1)+"</td>");
                        out.print("<td>"+rs.getString(1)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
                        out.print("<td>"+rs.getString(2)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");
                        out.print("<td>"+rs.getString(3)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");
                        out.print("<td>"+rs.getString(4)+"</td></tr>");
			out.print("<tr><td>"+rsmd.getColumnName(5)+"</td>");
                        out.print("<td>"+rs.getString(5)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(6)+"</td>");
                        out.print("<td>"+rs.getString(6)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(7)+"</td>");
                        out.print("<td>"+rs.getString(7)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(8)+"</td>");
                        out.print("<td>"+rs.getString(8)+"</td></tr>");   
			out.print("<tr><td>"+rsmd.getColumnName(9)+"</td>");
                        out.print("<td>"+rs.getString(9)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(10)+"</td>");
                        out.print("<td>"+rs.getString(10)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(11)+"</td>");
                        out.print("<td>"+rs.getString(11)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(12)+"</td>");
                        out.print("<td>"+rs.getString(12)+"</td></tr>"); 
			out.print("<tr><td>"+rsmd.getColumnName(13)+"</td>");
                        out.print("<td>"+rs.getString(13)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(14)+"</td>");
                        out.print("<td>"+rs.getString(14)+"</td></tr>");                    
                     }
		 out.print("</table>");
	}catch(Exception e){out.println(e);}
	}
	else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
}
}