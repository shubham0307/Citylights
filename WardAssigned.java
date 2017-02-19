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
 * Servlet implementation class WardAssigned
 */
@WebServlet("/WardAssigned")
public class WardAssigned extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WardAssigned() {
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
			String eid=request.getParameter("eid");
			String wid=request.getParameter("wid");
			PreparedStatement smt=cn.prepareStatement("insert into AssignWard values(?,?,?)");
			smt.setString(1, cid);
			smt.setString(2, wid);
			smt.setString(3, eid);
			smt.execute();
			out.println("Ward Assigned Successfully");
			out.println("<a href=AssignWard><b><i>Assign More Wards...</b></i></a>");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
