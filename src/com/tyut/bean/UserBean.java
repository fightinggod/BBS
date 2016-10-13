package com.tyut.bean;

public class UserBean {
	String userName=null;
	String userPwd=null;
	boolean logined =false;
	
	public UserBean(){
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public boolean isLogined() {
		return logined;
	}

	public void setLogined(boolean logined) {
		this.logined = logined;
	}
	
}
