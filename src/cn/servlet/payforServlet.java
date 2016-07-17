package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.Shopping;
import cn.dao.impl.MoneyDaoImpl;
import cn.dao.impl.OrdersDaoImpl;
import cn.dao.impl.ShoppingDaoImpl;

public class payforServlet extends HttpServlet {

	
	public payforServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int goodId=Integer.parseInt(request.getParameter("goodId"));
		int userId=Integer.parseInt(request.getParameter("userId"));
		String isflag=request.getParameter("isflag");
		System.out.println(goodId);
		System.out.println(Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId"))));
		
		ShoppingDaoImpl sdl=new ShoppingDaoImpl();
		Shopping sh=sdl.getShopping(goodId, userId);
		OrdersDaoImpl odl=new OrdersDaoImpl();
		MoneyDaoImpl mdl=new MoneyDaoImpl();
		boolean flag=mdl.updateAmount(sh);
		HttpSession session=request.getSession();
		if(flag)
		{
		odl.doOrders(sh);
		sdl.delOrderShopping(userId);
		session.setAttribute("flag", "yes");
		}else{
			session.setAttribute("flag", "no");
		}
		if(isflag.equals("go"))
		{
			response.sendRedirect("selBuyed.jsp");
		}else{
		response.sendRedirect("shopping.jsp");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	  this.doGet(request, response);
	}

}
