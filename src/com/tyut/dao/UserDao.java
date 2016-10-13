package com.tyut.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tyut.util.JDBCUtil;
import com.model.User;

//���ڲ����û����� ��ɾ�Ĳ�

public class UserDao {
	ResultSet rs = null;//�����
	PreparedStatement psmt = null;//Ԥ����
	public boolean login(String username,String password){
		
		boolean f = false;
		//1.�������ݿ�
			Connection con = JDBCUtil.getCon();
		//2.����sql���
			String sql = "select * from user where username=? and password=?";
		//3.����sql���
			try{
				psmt = con.prepareStatement(sql);//Ԥ����SQL���
				//4.���ò���
				psmt.setString(1, username);
				psmt.setString(2, password);
				//5.ִ��sql���
				rs = psmt.executeQuery();
				//6.��ȡ�����
				f = rs.next();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				//7.�ر����ݿ�����
				JDBCUtil.close(con, psmt, rs);;
			}
			return f;
	}
	public List<User> getUserList(){
		List<User> userList = new ArrayList<User>();
		
		Connection conn = JDBCUtil.getCon();
		String sql="select * from user";
		try{
			psmt = conn.prepareStatement(sql);
			
			rs= psmt.executeQuery();
		 
			while(rs.next()){
				 User user = new User();
	                user.setId(rs.getInt("id"));
	                user.setUsername(rs.getString("username"));
	                user.setPassword(rs.getString("password"));
	                user.setStatus(rs.getInt("status"));
	                userList.add(user);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		//7.�ر����ݿ�����
		JDBCUtil.close(conn, psmt, rs);;
}
		return userList;
		
}
	public boolean deleteUserById(String id) {
		int i =0;
		//1.�������ݿ�
			Connection con = JDBCUtil.getCon();
		//2.����sql���
			String sql = "delete  from  user where id=?";
		//3.����sql���
			try{
				psmt = con.prepareStatement(sql);//Ԥ����SQL���
				//4.���ò���
				psmt.setInt(1,Integer.parseInt(id) );
				//5.ִ��sql���
				i = psmt.executeUpdate();
				//6.��ȡ�����
				
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				//7.�ر����ݿ�����
				JDBCUtil.close(con, psmt, rs);;
			}
			return i>0;
	}
	public boolean regUser(String name, String pwd) {
		// TODO Auto-generated method stub
		int i =0;
		//1.�������ݿ�
			Connection con = JDBCUtil.getCon();
		//2.����sql���
			String sql = "insert into user(username,password) value(?,?)";
		//3.����sql���
			try{
				psmt = con.prepareStatement(sql);//Ԥ����SQL���
				//4.���ò���
				psmt.setString(1,name );
				psmt.setString(2,pwd );
				//5.ִ��sql���
				i = psmt.executeUpdate();
				//6.��ȡ�����
				
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				//7.�ر����ݿ�����
				JDBCUtil.close(con, psmt, rs);;
			}
			return i>0;
	}
	public List<User> getUserByVal(String val) {
        List<User> userList = new ArrayList<User>();
		
		Connection conn = JDBCUtil.getCon();
		String sql="select * from user where username like ?";
		try{
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,"%"+val+"%");
			rs= psmt.executeQuery();
		
			while(rs.next()){
				 User user = new User();
	                user.setId(rs.getInt("id"));
	                user.setUsername(rs.getString("username"));
	                user.setPassword(rs.getString("password"));
	                user.setStatus(rs.getInt("status"));
	                userList.add(user);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		//7.�ر����ݿ�����
		JDBCUtil.close(conn, psmt, rs);;
}
		return userList;
	}
	public User getUserById(String id) {
		    User user = new User();
			
			Connection conn = JDBCUtil.getCon();
			String sql="select * from user where id=?";
			try{
				psmt = conn.prepareStatement(sql);
				
				psmt.setInt(1,Integer.parseInt(id));
				rs= psmt.executeQuery();
			
				while(rs.next()){
					 
		                user.setId(rs.getInt("id"));
		                user.setUsername(rs.getString("username"));
		                user.setPassword(rs.getString("password"));
		                user.setStatus(rs.getInt("status"));
		                
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//7.�ر����ݿ�����
			JDBCUtil.close(conn, psmt, rs);;
	}
			return user;
	}
	public boolean editUserById(User user) {
		int i =0;
		//1.�������ݿ�
			Connection con = JDBCUtil.getCon();
		//2.����sql���
			String sql = "update user set password=? where id=?";
		//3.����sql���
			try{
				psmt = con.prepareStatement(sql);//Ԥ����SQL���
				//4.���ò���
				psmt.setString(1,user.getPassword() );
				psmt.setInt(2,user.getId() );
				//5.ִ��sql���
				i = psmt.executeUpdate();
				//6.��ȡ�����
				
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				//7.�ر����ݿ�����
				JDBCUtil.close(con, psmt, rs);;
			}
			return i>0;
	}
}