package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dao.impl.GoodsDaoImpl;



public class EditDelGoodsServlet extends HttpServlet {

	
	public EditDelGoodsServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		     int id=Integer.parseInt(request.getParameter("goodsid"));
		     String op=request.getParameter("op");
		     String toPage=null;
		     GoodsDaoImpl gdl=new GoodsDaoImpl();		     
		     HttpSession session=request.getSession();
		     PrintWriter out = response.getWriter();
		     if(op.equals("del"))
		     {
		     gdl.delGoods(id);    
		     session.setAttribute("flag", true);
		     toPage=request.getContextPath()+"/content/goodsManage/searchGoods.jsp";
		     }
		     
		     if(op.equals("edit"))
		     {
		    	session.setAttribute("good", gdl.getGoods(id));
		    	 toPage=request.getContextPath()+"/content/goodsManage/updateGoods.jsp";
		     }
		     if(op.equals("sel"))
		     {
		    	 session.setAttribute("goods", gdl.getGoods(id));
		    	 toPage="selBuyed.jsp";
		     }
		     
		     response.sendRedirect(toPage);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	  this.doGet(request, response);
	}

}
