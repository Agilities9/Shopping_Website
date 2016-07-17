package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dao.impl.UserDaoImpl;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	public RegisterServlet() {
		super();
	}

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
		UserDaoImpl userDao=new UserDaoImpl();
        String name=request.getParameter("username");
        String pwd=request.getParameter("password");
        
        String sex=request.getParameter("sex");
        String add1=request.getParameter("address");
        String add2=request.getParameter("city");
        String add=add1+add2;
        String que=request.getParameter("question");
        String ans=request.getParameter("answer");
        boolean isFlag=userDao.doUsers(name,pwd,sex,add,que,ans);
        
	   	if(isFlag)
	   	{
	   		response.sendRedirect("login.jsp");
	   	}
	   	else
	   	{
	   		response.sendRedirect("Register.jsp");
	   	}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		
	}

}
