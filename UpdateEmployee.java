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
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		
		
		
		
		
		
		
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/citylightss","root","shubham");
			PreparedStatement smt=cn.prepareStatement("Select * from employees where Emp_Id=?");
			String eid=request.getParameter("eid");
			smt.setString(1, eid);
			ResultSet rs=smt.executeQuery();
			if(rs.next())
			{
				String dob=rs.getString(3);
				String date[]=dob.split("-");
				String day[]=date[2].split(" ");
				out.println("<script src=employee.js></script>" +
						"<script src=DateCheck.js></script>" +
						"<html>" +
						"<caption><h1><b><i>Update Employee</i></b></caption>" +
						"<form action=EmployeeUpdated action=EmployeeUpdated method=post name=myform>" +
						"<body onload=fillCountry();fillYear();>" +
						"<table>" +
						"<tr><td><b><i>Employee ID:</i></b></td><td><input type=text name=eid id=eid value="+rs.getString(1)+"></td></tr>" +
						"<tr><td><b><i>Employee Name:</i></b></td><td><input type=text name=en id=en value="+rs.getString(2)+"></td></tr>" +
						"<tr><td><b><i>Employee DOB:</i></b></td><td><select name=Year id=yr onchange=fillMonth();><option>"+date[0]+"</option></select>&nbsp;&nbsp;<select name=month id=mth onchange=fillDay();><option>"+date[1]+"</option></select>&nbsp;&nbsp;<select name=day id=day><option>"+day[0]+"</option></select></td></tr>");
				if(rs.getString(4).equals("Male"))
				{
					out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=eg id=eg value=Male checked>Male<input type=radio name=eg value=Female>Female</td></tr>");
					
				}
				else
				{
					out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=eg id=eg value=Male>Male<input type=radio name=eg value=Female checked>Female</td></tr>");
				}
				out.println("<tr><td><b><i>Address:</i></b></td><td><textarea rows=3 cols=25 name=ea id=ea>"+rs.getString(5)+"</textarea></td></tr>" +
						"<tr><td><b><i>Country:</b></i></td><td><select name=ec id=ec onchange=fillState(); onselect=clear();><option>"+rs.getString(6)+"</option></select></td><td><span id=mecn></span></td></tr>" +
						"<tr><td><b><i>State:</b></i></td><td><select name=es id=es onchange=fillCity();><option>"+rs.getString(7)+"</option></select></td><td><span id=mes></span></td></tr>" +
						"<tr><td><b><i>City:</b></i></td><td><select name=ect id=ect><option>"+rs.getString(8)+"</option></select></td><td><span id=mect></span></td></tr>" +
						"<tr><td><b><i>Contact No:</i></b></td><td><input type=text name=ecn id=ecn value="+rs.getString(9)+"></td></tr>" +
						"<tr><td><b><i>Email ID:</i></b></td><td><input type=text name=emid id=emid value="+rs.getString(10)+"></td></tr>" +
						"<tr><td><b><i>Designation:</i></b></td><td><input type=text name=eds id=eds value="+rs.getString(11)+"></td></tr>" +
						"<tr><td><b><i>Picture:</b></i></td><td><input type=file name=pic id=pic><img src=players/"+rs.getString(13)+" width=50 height=50></td><td><span id=mpic></span></td></tr>" +
						"<tr><td><input type=submit value=Edit name=btn></td><td><input type=submit value=Delete&nbsp;Employee&nbsp;Record name=btn></td></tr>");
				out.println("</table></form></body></html>");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
