package com.goutham.leetcode.utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Inventory {
    private String name;
    private Double price;
    private String department;
    private int id;
    private int stock;
    
    
    
	public Inventory(String name, Double price, String department, int id, int stock) {
		super();
		this.name = name;
		this.price = price;
		this.department = department;
		this.id = id;
		this.stock = stock;
	}
	private static NumberFormat formatter = new DecimalFormat("#0.00");
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
    
	   @Override
	    public String toString() {
	        return String.format("ID: %d\r\nDepartment: %s\r\nName: %s\r\nPrice: %s\r\nStock: %d\r\n", 
	                id, department, name, formatter.format(price), stock);
	    }
    

}
