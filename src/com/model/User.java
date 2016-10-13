package com.model;

public class User {
	public int id;
	public String username;
	public String password;
	public int status;
	
	public User(int id, String username, String password, int status){
		super();
		this.id=id;
		this.username=username;
		this.password=password;
		this.status=status;
		
	}
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
}
