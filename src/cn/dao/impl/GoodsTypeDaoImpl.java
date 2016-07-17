package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.GoodsType;
import cn.dao.GoodsTypeDao;
import cn.dbc.BaseDao;

public class GoodsTypeDaoImpl implements GoodsTypeDao {

	BaseDao bs=new BaseDao();
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    
	@Override
	public void addType(GoodsType goodsType) {
      String sql="insert into goodsType values(?,?)";
		 
		 try {
			conn=bs.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1,goodsType.getId());
			pstmt.setString(2,goodsType.getTypeName());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bs.closeConn(conn, pstmt, rs);
		}

	}

	@Override
	public List<GoodsType> selAllGoodsType() {
		List<GoodsType> types=new ArrayList();
		GoodsType type=null;
		String sql="select * from goodsType";
		 
		
			try {
				conn=bs.getConnection();
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					type=new GoodsType();
					type.setId(rs.getInt("id"));
					type.setTypeName(rs.getString("typename"));
					types.add(type);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				bs.closeConn(conn, pstmt, rs);
			}
			
		return types;
	}

}
