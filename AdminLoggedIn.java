package com.mpeb;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLoggedIn
 */
@WebServlet("/AdminLoggedIn")
public class AdminLoggedIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoggedIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try{
			new com.mysql.jdbc.Driver();
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/citylightss","root","shubham");
			String aid=request.getParameter("aid");
			String pwd=request.getParameter("pwd");
			PreparedStatement smt=cn.prepareStatement("select * from admin where Admin_ID=? and Admin_password=?");
			smt.setString(1, aid);
			smt.setString(2, pwd);
			ResultSet rs=smt.executeQuery();
			if(rs.next())
			{
				HttpSession ases=request.getSession();
				ases.putValue("said", aid);
				ases.putValue("ldate", new java.util.Date());
				response.sendRedirect("AdminHome");
			}
			else{
				response.sendRedirect("AdminLogin");
			}
			
			cn.close();
		}
		catch(Exception e){
			out.println(e);
		}
	}

}
