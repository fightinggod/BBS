package com.tyut.util;

import java.sql.*;


public class JDBCUtil {
	private static final String Driver ="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf8";
	private static final String user ="root";
	private static final String pwd ="";
	
	public static Connection getCon(){
		Connection con = null;
		try{
			Class.forName(Driver);
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("���ӳɹ�");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con,Statement stmt,ResultSet rs){
			try{
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(con!=null){
				con.close();
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	
	
}
