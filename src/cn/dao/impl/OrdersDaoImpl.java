package cn.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Orders;
import cn.bean.Shopping;
import cn.dao.OrdersDao;
import cn.dbc.BaseDao;

public class OrdersDaoImpl implements OrdersDao {

	BaseDao bs=new BaseDao();
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    
    public List<Orders> getUserOrders(int userId)
    {
    	List<Orders> list=new ArrayList();
    	Orders order=null;
    	String sql="select * from orders where userId=?";
    	
    	conn=bs.getConnection();
    	try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				order=new Orders();
				order.setGoodsName(rs.getString("goodName"));
				order.setGoodsPrice(rs.getFloat("goodPrice"));
				order.setGoodsDe(rs.getString("goodDe"));
				list.add(order);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return list;
    }
    
	@Override
	public void doOrders(Shopping sh) {
		String sql="insert into orders values(?,?,?,?,?,?,?)";
		
		conn=bs.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sh.getGoodsId());
			pstmt.setString(2, sh.getGoodsName());
			pstmt.setFloat(3, sh.getGoodsPrice());
			pstmt.setInt(4,sh.getGoodsCount());
			pstmt.setString(5, sh.getGoodsDe());
            pstmt.setInt(6, sh.getGoodsType());
            pstmt.setInt(7, sh.getUserId());
            pstmt.executeUpdate();	
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
