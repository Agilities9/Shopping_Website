package cn.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.User;
import cn.dao.UserDao;
import cn.dbc.BaseDao;

public class UserDaoImpl implements UserDao {
	
	BaseDao bs=new BaseDao();
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    
    public int getUserId(String username)
    {
    	int id=0;
    	String sql="select id from users where username=?";
    	
    	conn=bs.getConnection();
    	try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				id=rs.getInt("id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return id;
    }
    public boolean modifyPwd(String username,String password)
    {
    	boolean flag=false;
    	String sql="update users set password=? where username=?";
    	
    	conn=bs.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			int num=pstmt.executeUpdate();
			if(num>0)
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return flag;
    }
    
    public int isAdmin(User user)
    {
    	int num=0;
    	conn=bs.getConnection();
		String sql="select * from users where username=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				num=rs.getInt("roleType");
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	return num;
    }
    
    public User findUserSecret(String username)
    {
    	User user=null;
		
		conn=bs.getConnection();
		String sql="select * from users where username=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				user=new User();
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bs.closeConn(conn, pstmt, rs);
		}
		
		return user;
   	
    }
 
    public boolean findUserOne(String username)
    {
    	boolean flag=false;
		
		conn=bs.getConnection();
		String sql="select * from users where username=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bs.closeConn(conn, pstmt, rs);
		}
		
		return flag;
   	
    }
    
	@Override
	
	public List<User> findAllUser()
	{
		List<User> list=new ArrayList<User>();
		 String sql="select * from users";
		 User user=null;
		 
		 try {
			conn=bs.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("username"));
				user.setSex(rs.getString("sex"));
				user.setRoleType(rs.getInt("roleType"));
				user.setAddress(rs.getString("address"));
				list.add(user);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			bs.closeConn(conn, pstmt, rs);
		}
		 
		return list;
	}
	
	public boolean findUser(User user) {
		 boolean flag=false;
			
			conn=bs.getConnection();
			String sql="select * from users where username=? and password=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getPassword());
				rs=pstmt.executeQuery();
				if(rs.next())
				{
					flag=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				bs.closeConn(conn, pstmt, rs);
			}
			
			return flag;

	}
	
	public boolean doUsers(String username, String password, String sex, String address,String question, String answer) {		
		
		boolean isFlag=false;
		conn=bs.getConnection();
		String sql="insert into users(username,password,sex,address,question,answer) values(?,?,?,?,?,?)";
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			pstmt.setString(3,sex);
			pstmt.setString(4,address);
			pstmt.setString(5,question);
			pstmt.setString(6,answer);
			int num=pstmt.executeUpdate();
			if(num>0)
			{
				isFlag=true;
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			bs.closeConn(conn, pstmt, rs);
		}
		return isFlag;
	}

}
