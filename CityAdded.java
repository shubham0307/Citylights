package com.mpeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CityAdded
 */
@WebServlet("/CityAdded")
public class CityAdded extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityAdded() {
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
			String cnm=request.getParameter("cnm");
			PreparedStatement smt=cn.prepareStatement("insert into city values(?,?)");
			smt.setString(1, cid);
			smt.setString(2, cnm);
			smt.execute();
			out.println("City Added Successfully");
			
			
			smt.executeUpdate("update autogen set city_id=city_id+1");
			cn.close();
			out.println("<a href=AddCity>Add More Cities</a>");
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
