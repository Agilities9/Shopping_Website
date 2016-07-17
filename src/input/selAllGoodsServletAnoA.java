package input;

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

public class selAllGoodsServletAnoA extends HttpServlet {

	
	public selAllGoodsServletAnoA() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    int goodsType=Integer.parseInt(request.getParameter("goodsType"));
    String goodsName=request.getParameter("goodsName");
    System.out.println(goodsType);
    List<Goods> lgg=new ArrayList<Goods>();
	GoodsDaoImpl gdl=new GoodsDaoImpl();
			
	
    if(goodsType>=0)
    {
       lgg=gdl.getGood(goodsType);    	
    	
    }else{
    	lgg=gdl.getGoods(goodsName);
    }
    
    request.getSession().setAttribute("lgg",lgg);
    response.sendRedirect("lookupGoods.jsp");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	      this.doGet(request, response);
	}

}
