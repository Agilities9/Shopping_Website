package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dao.impl.UserDaoImpl;

public class ForgetServlet extends HttpServlet {

	
	public ForgetServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("username");
		UserDaoImpl udl=new UserDaoImpl();
		HttpSession session=request.getSession();
		boolean flag=udl.findUserOne(name);
		if(flag)
		{
			session.setAttribute("username",name);
			response.sendRedirect("certain.jsp");
		}
		else{
			  session.setAttribute("flag",false);
			   response.sendRedirect("forget.jsp"); 			
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	  this.doGet(request, response);
	}

}
