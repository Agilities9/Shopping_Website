package cn.servlet;

import java.io.IOException;

import cn.bean.GoodsType;
import cn.dao.impl.GoodsTypeDaoImpl;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addGoodsTypeServlet extends HttpServlet {

	
	public addGoodsTypeServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    int typeId=Integer.parseInt(request.getParameter("typeID"));
	    String typeName=request.getParameter("typeName");	
	    
	    GoodsType gt=new GoodsType();
	    gt.setId(typeId);
	    gt.setTypeName(typeName);
	    
	    GoodsTypeDaoImpl td=new GoodsTypeDaoImpl();
	    td.addType(gt);
	    
	    String toPage=request.getContextPath()+"/content/goodsManage/mainDisplay.jsp";
	    response.sendRedirect(toPage);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

     this.doGet(request, response);
	}

}
