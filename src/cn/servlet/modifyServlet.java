package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.User;
import cn.dao.impl.UserDaoImpl;

public class modifyServlet extends HttpServlet {

	
	public modifyServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       String pwd=request.getParameter("pwd");
     
       String name=request.getSession().getAttribute("username").toString();
       UserDaoImpl udl=new UserDaoImpl();
       boolean flag=udl.modifyPwd(name, pwd);
       PrintWriter out=response.getWriter();
       if(flag)
       {
    	   out.println("<script>alert('ÃÜÂëÐÞ¸Ä³É¹¦£¡');</script>");
    	   response.sendRedirect("login.jsp");
       }
       
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   this.doGet(request, response);
	}

}
