package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.bean.Shopping;
import cn.dao.MoneyDao;
import cn.dbc.BaseDao;

public class MoneyDaoImpl implements MoneyDao {

	BaseDao bs=new BaseDao();
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    
	@Override
	public float getAmount(int userId) {
		float amount=0;
		String sql="select * from money where userId=?";
		
		conn=bs.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
			  amount=rs.getFloat("amount");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;
	}
	
	public boolean updateAmount(Shopping sh)
	{
		boolean flag=false;
		MoneyDaoImpl mdl=new MoneyDaoImpl();
		float amount=mdl.getAmount(sh.getUserId());
		float goodsPrice=sh.getGoodsPrice();
		float newAmount=amount-goodsPrice;
		
		if(newAmount>=0)
		{
			flag=true;
		}else{
			return flag;
		}		
		
		String sql="update money set amount=? where userId=?";
		
		conn=bs.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setFloat(1, newAmount);
			pstmt.setInt(2, sh.getUserId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			bs.closeConn(conn, pstmt, rs);
		}
		
			return flag;	
		
	}

}
