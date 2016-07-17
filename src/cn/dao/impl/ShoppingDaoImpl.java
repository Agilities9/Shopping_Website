package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Goods;
import cn.bean.Shopping;
import cn.dao.ShoppingDao;
import cn.dbc.BaseDao;

public class ShoppingDaoImpl implements ShoppingDao {

	BaseDao bs=new BaseDao();
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    
    public Shopping getShopping(int goodId,int userId)
    {
    	Shopping sh=null;
    	String sql="select * from trolley where goodId=? and userId=?";
    	conn=bs.getConnection();
    	try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, goodId);
			pstmt.setInt(2, userId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				sh=new Shopping();
				sh.setGoodsId(rs.getInt("goodId"));
				sh.setGoodsName(rs.getString("goodName"));
				sh.setGoodsPrice(rs.getFloat("goodPrice"));
				sh.setGoodsCount(rs.getInt("goodCount"));
				sh.setGoodsDe(rs.getString("GoodDe"));
				sh.setGoodsType(rs.getInt("goodType"));
				sh.setUserId(rs.getInt("userId"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return sh;
    }
    
    public void delShopping(int goodId,int userId)
    {
    	String sql="delete from trolley where goodId=? and userId=?";
    	
    	conn=bs.getConnection();
    	try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, goodId);
			pstmt.setInt(2, userId);
			
			int num=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bs.closeConn(conn, pstmt, rs);
		}
    }
    
    
	@Override
	public List<Shopping> getOrderShopping(int userId) {
		List<Shopping> list=new ArrayList();
		Shopping sh=null;
		
		String sql="select * from trolley where userId=?";
		
		conn=bs.getConnection();
		try {
		
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs=pstmt.executeQuery();
			while(rs.next())
			{	
				sh=new Shopping();
				sh.setGoodsId(rs.getInt("goodId"));
				sh.setGoodsName(rs.getString("goodName"));
				sh.setGoodsPrice(rs.getFloat("goodPrice"));
				sh.setGoodsCount(rs.getInt("goodCount"));
				sh.setGoodsDe(rs.getString("goodDe"));
				sh.setGoodsType(rs.getInt("goodType"));
				sh.setUserId(userId);
				System.out.println(sh.getGoodsName());
				
				list.add(sh);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bs.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public void delOrderShopping(int userId) {
		// TODO Auto-generated method stub

	}

}
