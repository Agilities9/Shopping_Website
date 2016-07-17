package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.User;
import cn.dao.impl.UserDaoImpl;

public class LoginServlet extends HttpServlet {

	
	public LoginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("username");
	    String pwd=request.getParameter("password");
		
	    User user=new User();
	    user.setName(name);
	    user.setPassword(pwd);
	    HttpSession session=request.getSession();
	    UserDaoImpl udl=new UserDaoImpl();
	    int userId=udl.getUserId(name);
	    boolean flag=udl.findUser(user);
	   if(flag)
	   {
		  if(udl.isAdmin(user)==1)
		  {
			  response.sendRedirect("main.html");
		  }
		  else{
			  session.setAttribute("userId", userId);
			  response.sendRedirect("mainUser.html");
		  }
		  
	   } else{  
	       session.setAttribute("flag",false);
		   response.sendRedirect("login.jsp");
		   }

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

   this.doGet(request, response);
	}

}
