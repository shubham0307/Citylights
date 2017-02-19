package com.mpeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminRegistration
 */
@WebServlet("/AdminRegistration")
public class AdminRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegistration() {
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
		out.println("<script src=\"Admin.js\"></script>" +
				"<html>" +
				"<table>" +
				"<caption><h3><i>Administrator Registration</i></caption>" +
				"<form action=AdminSubmit method=post onsubmit=\"return chksubmit();\"\"return passMatch();\"\"return passStrength();\">" +
				"<tr><td><span id=mad><font size=1 color=red>* All Fields Are Mandatory</font></span></td></tr>" +
				"<tr><td><b><i>Admin ID<sup>*</sup>:</i></b></td><td><input type=text name=aid id=aid></td><td><span id=maid></span></td></tr>" +
				"<tr><td><b><i>Name<sup>*</sup>:</i></b></td><td><input type=text name=an id=an></td><td><span id=man></span></td></tr>" +
				"<tr><td><i><b>Contact Number<sup>*</sup>:</i></b></td><td><input type=text name=ac id=ac onkeyup=\"chkMobilee();\"></td><td><span id=mac></span></td></tr>" +
				"<tr><td><i><b>Email ID<sup>*</sup>:</i></b></td><td><input type=text name=ae id=ae></td><td><span id=mae></span></td></tr>" +
				"<tr><td><i><b>Password<sup>*</sup>:</i></b></td><td><input type=password name=pwd id=pwd onkeyup=\"passStrength();\"></td><td><span id=mpwd></span><img src=ps0.gif id=im></td></tr>" +
				"<tr><td><i><b>Confirm Password<sup>*</sup>:</i></b></td><td><input type=password name=cpwd id=cpwd onkeyup=\"passMatch();\"></td><td><span id=mcpwd></span></td></tr>" +
				"<tr><td><input type=submit value=Register></td><td><input type=reset value=Reset></td></tr>" +
				"</table>" +
				"</form>" +
				"</html>");
				out.flush();
	}

}
