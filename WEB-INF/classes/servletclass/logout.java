package servletclass;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class logout extends HttpServlet
{
protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
{
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	HttpSession session=request.getSession();  
            session.invalidate();   
            out.print("You are successfully logged out!");  
	request.getRequestDispatcher("thanks.html").include(request, response);  	
}
}