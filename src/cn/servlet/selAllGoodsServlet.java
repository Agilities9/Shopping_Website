package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.Goods;
import cn.dao.impl.GoodsDaoImpl;


public class selAllGoodsServlet extends HttpServlet {


	public selAllGoodsServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("productID");
		int goodsId;
		if(id!="")
		{
			goodsId=Integer.parseInt(id);
		}else{
			goodsId=0;
		}
        
       String goodsName=request.getParameter("productName");
       GoodsDaoImpl gdl=new GoodsDaoImpl();
       List<Goods> lg=new ArrayList();
        if(goodsId!=0)
        {
        	lg.add(gdl.getGoods(goodsId));
        	
        }else
		{
			lg=gdl.getGoods(goodsName);
		}
        
        HttpSession session=request.getSession();
        session.setAttribute("lg",lg);
        
        String toPage=request.getContextPath()+"/content/goodsManage/searchGoods.jsp";
        response.sendRedirect(toPage);
            
       
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	   this.doGet(request,response);
	}

}
