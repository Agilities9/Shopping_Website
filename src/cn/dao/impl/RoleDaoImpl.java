package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.dao.RoleDao;
import cn.dbc.BaseDao;

public class RoleDaoImpl implements RoleDao {

	BaseDao bs=new BaseDao();
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    
	@Override
	public String selType(int roleId) {
		String roleName=null;
	    String sql="select * from roles where id=?";
	  
	  conn=bs.getConnection();
	  try {
		  pstmt=conn.prepareStatement(sql);
		  pstmt.setInt(1, roleId);
		  rs=pstmt.executeQuery();
		  
		  if(rs.next())
		  {
			  roleName=rs.getString("roleName");
		  }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return roleName;
	}

}
