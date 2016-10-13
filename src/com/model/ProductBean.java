package com.model;

public class ProductBean {
	private float price;
	private int num;
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getTotalPrice() {
		return this.num *this.price;
	}
	
}
