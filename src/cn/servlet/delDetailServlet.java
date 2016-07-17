package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dao.impl.ShoppingDaoImpl;

public class delDetailServlet extends HttpServlet {

	
	public delDetailServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int goodId=Integer.parseInt(request.getParameter("goodId"));
		int userId=Integer.parseInt(request.getParameter("userId"));
		
		ShoppingDaoImpl sdl=new ShoppingDaoImpl();
		sdl.delShopping(goodId, userId);
		
		PrintWriter out=response.getWriter();
		out.print("<script type='text/javascript'/>alert('É¾³ý³É¹¦£¡');</script>");
		response.sendRedirect("shopping.jsp");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
