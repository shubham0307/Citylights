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
 * Servlet implementation class AreaAdded
 */
@WebServlet("/AreaAdded")
public class AreaAdded extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaAdded() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/citylightss","root","shubham");
			String aid=request.getParameter("aid");
			String an=request.getParameter("an");
			String wid=request.getParameter("wid");
			PreparedStatement smt=cn.prepareStatement("insert into area values(?,?,?)");
			smt.setString(1, aid);
			smt.setString(2, wid);
			smt.setString(3, an);
			smt.execute();
			out.println("Area Added Successfully");
			
			smt.executeUpdate("update autogen set area_id=area_id+1");
			out.println("<a href=AddArea><b><i>Add More Areas...</b></i></a>");
			
			
			
		}
		catch(Exception e)
		{
			out.println(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
