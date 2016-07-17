package cn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao
{

    /*
     * ���ݿ�������Լ��ر���
     */
	public Connection getConnection()
	{
		Connection conn=null;
		try
		{
			//Ӧ�ó���������ָ�������ݿ������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//�����ַ��ܣ���ʵ������
			//�����ƶ����ݿ�������µľ������ݿ�
			conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Shopping","sa","511409");//�����ַ���
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
