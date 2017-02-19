package com.mpeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeSubmit
 */
@WebServlet("/EmployeeSubmit")
public class EmployeeSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/citylightss","root","shubham");
			String eid=request.getParameter("eid");
			String en=request.getParameter("en");
			String Year=request.getParameter("Year");
			String month=request.getParameter("month");
			String day=request.getParameter("day");
			String eb=Year+"/"+month+"/"+day;
			String eg=request.getParameter("eg");
			String ea=request.getParameter("ea");
			String ec=request.getParameter("ec");
			String es=request.getParameter("es");
			String ect=request.getParameter("ect");
			String ecn=request.getParameter("ecn");
			String emid=request.getParameter("emid");
			String eds=request.getParameter("eds");
			String pwd=request.getParameter("pwd");
			String pic=request.getParameter("pic");
			pic=pic.substring(pic.lastIndexOf("\\")+1);
			
			PreparedStatement smt=cn.prepareStatement("Insert into employees values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			smt.setString(1, eid);
			smt.setString(2, en);
			smt.setString(3, eb);
			smt.setString(4, eg);
			smt.setString(5, ea);
			smt.setString(6, ec);
			smt.setString(7, es);
			smt.setString(8, ect);
			smt.setString(9, ecn);
			smt.setString(10, emid);
			smt.setString(11, eds);
			smt.setString(12, pwd);
			smt.setString(13, pic);
			smt.execute();
			out.println("Employee Registered Successfully");
			cn.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
