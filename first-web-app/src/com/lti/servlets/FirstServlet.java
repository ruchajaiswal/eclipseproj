package com.lti.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;

public class FirstServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		String name = request.getParameter("fname");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>First Servlet</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>Welcome</h1>" + name);
//		out.println("</body>");
//		out.println("</html>");
		String uname = request.getParameter("uname");
		String password = request.getParameter("passw");
		
		if(uname.equals("rucha")&&password.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("name", uname);
			RequestDispatcher rd = request.getRequestDispatcher("welcome");
			rd.forward(request, response);
			
		}
		else {
			out.println("Incorrect username and password...Try again!!!");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
	}

}
