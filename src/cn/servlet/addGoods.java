package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Goods;
import cn.dao.impl.GoodsDaoImpl;



public class addGoods extends HttpServlet {

	
	public addGoods() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	     String ProductName=request.getParameter("ProductName");
	     float productPrice=Float.parseFloat(request.getParameter("productPrice"));
	     int productNumber=Integer.parseInt(request.getParameter("productNumber"));
	     String description=request.getParameter("description");
	     int goodsType=Integer.parseInt(request.getParameter("goodsType"));
	     
	     Goods goods=new Goods();
	     goods.setGoodsName(ProductName);
	     goods.setGoodsPrice(productPrice);
	     goods.setGoodsCount(productNumber);
	     goods.setGoodsDe(description);
	     goods.setGoodsType(goodsType);
	     
	     GoodsDaoImpl gdl=new GoodsDaoImpl();
	     gdl.doGoods(goods);
	     
	     String toPage=request.getContextPath()+"/content/goodsManage/searchGoods.jsp";
	     response.sendRedirect(toPage);
	     
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

  this.doGet(request, response);
	}

}
