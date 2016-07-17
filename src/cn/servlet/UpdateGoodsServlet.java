package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Goods;
import cn.dao.impl.GoodsDaoImpl;



public class UpdateGoodsServlet extends HttpServlet {

	
	public UpdateGoodsServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        int productID=Integer.parseInt(request.getParameter("productID"));
        String productName=request.getParameter("productName");
        String productDep=request.getParameter("productDep");
        int productType=Integer.parseInt(request.getParameter("productType"));
       float productPrice=Float.parseFloat(request.getParameter("productPrice"));
       int productCount=Integer.parseInt(request.getParameter("productCount"));
 
       Goods good=new Goods();
       good.setGoodsId(productID);
       good.setGoodsName(productName);
       good.setGoodsPrice(productPrice);
       good.setGoodsCount(productCount);
       good.setGoodsType(productType);
       good.setGoodsDe(productDep);
 
      GoodsDaoImpl gd=new GoodsDaoImpl();
      gd.updateGoods(good); 
 
      RequestDispatcher dispatcher=request.getRequestDispatcher("/selAllGoodsServlet");
      dispatcher.forward(request,response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	  this.doGet(request, response);
	}

}
