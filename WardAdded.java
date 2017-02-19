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
 * Servlet implementation class WardAdded
 */
@WebServlet("/WardAdded")
public class WardAdded extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WardAdded() {
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
			String cid=request.getParameter("cid");
			String wn=request.getParameter("wn");
			String wid=request.getParameter("wid");
			PreparedStatement smt=cn.prepareStatement("insert into ward values(?,?,?)");
			smt.setString(1, wid);
			smt.setString(2, cid);
			smt.setString(3, wn);
			smt.execute();
			out.println("Ward Added Successfully");
			
			smt.executeUpdate("update autogen set Ward_id=Ward_id+1");
			out.println("<a href=AddWard><b>Add More Wards...</b></a>");
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
