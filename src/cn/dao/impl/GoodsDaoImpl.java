package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;








import cn.bean.Goods;
import cn.dao.GoodsDao;
import cn.dbc.BaseDao;

public class GoodsDaoImpl implements GoodsDao {

	BaseDao bs=new BaseDao();
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    
    public List<Goods> getGood(int goodsType)
    {
    	List<Goods> lg=new ArrayList();
    	Goods good=null;
    	String sql="select * from goods where goodsType=?";
    	
    	conn=bs.getConnection();
    	try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, goodsType);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
    			good=new Goods();
				good.setGoodsId(rs.getInt("goodsId"));
				good.setGoodsName(rs.getString("goodsName"));
				good.setGoodsPrice(rs.getFloat("goodsPrice"));
				good.setGoodsCount(rs.getInt("goodsCount"));
				good.setGoodsDe(rs.getString("goodsDe"));
				good.setGoodsType(rs.getInt("goodsType"));
				lg.add(good);
            }
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    	return lg;
    }
    public List<Goods> getGoods(String goodsName)
	{
    	System.out.println("hello");
		List<Goods> lg=new ArrayList();
		Goods good=null;
		String sql="select * from goods where goodsName=?";
		
		try {
			conn=bs.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,goodsName);
			rs=pstmt.executeQuery();
			System.out.println("hello");
			while(rs.next())
			{
			
				good=new Goods();
				good.setGoodsId(rs.getInt("goodsId"));
				good.setGoodsName(rs.getString("goodsName"));
				good.setGoodsPrice(rs.getFloat("goodsPrice"));
				good.setGoodsCount(rs.getInt("goodsCount"));
				good.setGoodsDe(rs.getString("goodsDe"));
				good.setGoodsType(rs.getInt("goodsType"));
				
				lg.add(good);
			}
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bs.closeConn(conn, pstmt, rs);
		}
		
		return lg;
	}
    
    public Goods getGoods(int id) {
		Goods good=new Goods();
		String sql="select * from goods where goodsId=?";
		
		try {
			conn=bs.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				good.setGoodsId(rs.getInt("goodsID"));
				good.setGoodsName(rs.getString("goodsName"));
				good.setGoodsPrice(rs.getFloat("goodsPrice"));
				good.setGoodsCount(rs.getInt("goodsCount"));
				good.setGoodsDe(rs.getString("goodsDe"));
				good.setGoodsType(rs.getInt("goodsType"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bs.closeConn(conn, pstmt, rs);
		}
		
		
		return good;
	}
    
	@Override
	public List<Goods> getGoods() {
		
		return null;
	}

	@Override
	public void doGoods(Goods goods) {
String sql="insert into goods(goodsName,goodsPrice,goodsCount,goodsDe,goodsType) values(?,?,?,?,?)";
		
		try {
			conn=bs.getConnection();
			pstmt=conn.prepareStatement(sql);

			
			pstmt.setString(1,goods.getGoodsName());
			pstmt.setDouble(2,goods.getGoodsPrice());
			pstmt.setInt(3,goods.getGoodsCount());
			pstmt.setString(4,goods.getGoodsDe());
			pstmt.setInt(5,goods.getGoodsType());
			
			pstmt.executeUpdate();
			
		} 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bs.closeConn(conn, pstmt, rs);
		}

	}

	@Override
	public void delGoods(int id) {
      String sql="delete from goods where goodsId=?";
		
		try {
			conn=bs.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bs.closeConn(conn, pstmt, rs);
		}

	}

	@Override
	public void updateGoods(Goods goods) {
         String sql="update goods set goodsName=?,goodsPrice=?,goodsCount=?,goodsDe=?,goodsType=? where goodsId=?";
		
		try {
			conn=bs.getConnection();
            pstmt=conn.prepareStatement(sql);

            
			pstmt.setString(1,goods.getGoodsName());
			pstmt.setFloat(2,(float) goods.getGoodsPrice());
			pstmt.setInt(3,goods.getGoodsCount());
			pstmt.setString(4,goods.getGoodsDe());
			pstmt.setInt(5,goods.getGoodsType());
			pstmt.setInt(6,goods.getGoodsId());
			pstmt.executeUpdate();
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bs.closeConn(conn, pstmt, rs);
		}

	}

}
