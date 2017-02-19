package com.mpeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeInterface
 */
@WebServlet("/EmployeeInterface")
public class EmployeeInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeInterface() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		HttpSession ases=request.getSession(false);
		String aid="";
		String cdt="";
		try{
			aid=ases.getValue("said").toString();
			cdt=ases.getValue("ldate").toString();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/citylightss","root","shubham");
			Statement smt=cn.createStatement();
			ResultSet rs=smt.executeQuery("Select * from admin where admin_id='"+aid+"'");
			String an="";
			String ac="";
			String ae="";
			if(rs.next())
			{
				an=rs.getString(2);
				ac=rs.getString(3);
				ae=rs.getString(4);
			}
			String nav="<html>" +
					"<h4 title=Admin&nbsp;Details><center><font color=green>"+an+"<br>"+ac+"<br>"+ae+"</font></center></h4>" +
					"<p align=left><font color=green><b>"+cdt+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></p></b></font>" +
					"<hr color=red>";
			out.println(nav);
		}
		catch(Exception e)
		{
			response.sendRedirect("AdminLogin");
		}
		
		
		
		
		
		
		
		
		out.println("<script src=employee.js></script>" +
				"<script src=DateCheck.js></script>" +
				"<html>" +
				"<form action=EmployeeSubmit method=post name=myform>" +
				"<body onload=fillCountry();fillYear();>" +
				"<table>" +
				"<tr><td><b><i>Employee ID:</b></i></td><td><input type=text name=eid id=eid></td><td><span id=meid></span></td></tr>" +
				"<tr><td><b><i>Employee Name:</b></i></td><td><input type=text name=en id=en></td><td><span id=men></span></td></tr>" +
				"<tr><td><b><i>Birth Date:</b></i></td><td><select name=Year id=yr onchange=fillMonth();></select>&nbsp;&nbsp;<select name=month id=mth onchange=fillDay();></select>&nbsp;&nbsp;<select name=day id=day></select></td><td><span id=meb></span></td></tr>" +
				"<tr><td><b><i>Gender:</b></i></td><td><input type=radio value=Male name=eg id=eg>Male<input type=radio value=Female name=eg>Female</td><td><span id=meg></span></td></tr>" +
				"<tr><td><b><i>Address:</b></i></td><td><textarea rows=4 cols=30 name=ea id=ea></textarea></td><td><span id=mea></span></td></tr>" +
				"<tr><td><b><i>Country:</b></i></td><td><select name=ec id=ec onchange=fillState();></select></td><td><span id=mecn></span></td></tr>" +
				"<tr><td><b><i>State:</b></i></td><td><select name=es id=es onchange=fillCity();></select></td><td><span id=mes></span></td></tr>" +
				"<tr><td><b><i>City:</b></i></td><td><select name=ect id=ect></select></td><td><span id=mect></span></td></tr>" +
				"<tr><td><b><i>Contact No:</b></i></td><td><input type=text name=ecn id=ecn></td><td><span id=mecn></span></td></tr>" +
				"<tr><td><b><i>Email ID:</b></i></td><td><input type=text name=emid id=emid></td><td><span id=memid></span></td></tr>" +
				"<tr><td><b><i>Designation:</b></i></td><td><input type=text name=eds id=eds></td><td><span id=meds></span></td></tr>" +
				"<tr><td><b><i>Password:</b></i></td><td><input type=password name=pwd id=pwd></td><td><span id=mpwd></span></td></tr>" +
				"<tr><td><b><i>Confirm Password:</b></i></td><td><input type=password name=cpwd id=cpwd></td><td><span id=mcpwd></span></td></tr>" +
				"<tr><td><b><i>Picture:</b></i></td><td><input type=file name=pic id=pic></td><td><span id=mpic></span></td></tr>" +
				"<tr><td><input type=submit value=Register&nbsp;Employee name=sub id=sub></td><td><input type=reset value=Clear></td><td><span id=msub></span></td></tr>" +
				"</body>" +
				"</table>" +
				"</form>" +
				"</html>");
		out.flush();
	}

}
