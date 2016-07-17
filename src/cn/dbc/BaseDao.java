package cn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao
{

    /*
     * 数据库的连接以及关闭类
     */
	public Connection getConnection()
	{
		Connection conn=null;
		try
		{
			//应用程序连接上指定的数据库服务器
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//驱动字符窜，其实是类名
			//连接制定数据库服务器下的具体数据库
			conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Shopping","sa","511409");//连接字符窜
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConn(Connection conn,PreparedStatement pstmt,ResultSet rs)
	{
		try
		{
			if(rs!=null)
			{
				rs.close();
			}
			if(pstmt!=null)
			{
				pstmt.close();
			}
			if(conn!=null)
			{
				conn.close();
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
