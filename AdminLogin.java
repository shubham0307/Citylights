package com.mpeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>" +
				"<link href=css/LogSty.css rel=stylesheet>" +
				"<link href=css/LogFont.css rel=stylesheet>" +
				"<link href=css/LogSty2.css rel=stylesheet>" +
				"<script src=js/Logjs.js></script>");
		
	
		
		
		
		out.println("<body background=img/citylight.jpg>" +
				"<br><br><br><font color=white size=8><b><center>C I T Y L I G H T S</center></b></font>" +
				"<font color=white size=4><center>ADMIN LOGIN</center></font>" +
				"<section class=main>" +
				"<form class=form-1 action=AdminLoggedIn method=post>" +
				"<p class=field>" +
				"<input type=text name=aid id=aid placeholder=Username or email>" +
				"<i class=icon-user icon-large></i></p>" +
				"<p class=field>" +
				"<input type=password name=pwd id=pwd placeholder=Password>" +
				"<i class=icon-lock icon-large></i></p>" +
				"<p class=submit>" +
				"<button type=submit name=submit><i class=icon-arrow-right icon-large></i></button></p>" +
				"</form></section>" +
				"</body>" +
				"</html>");
		out.flush();
		
	}

}
