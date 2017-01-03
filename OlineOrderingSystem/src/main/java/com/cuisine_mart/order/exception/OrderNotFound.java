package com.cuisine_mart.order.exception;

public class OrderNotFound extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2168217376468710385L;
	public OrderNotFound() {
		super();
	}
	public OrderNotFound(String s) {
		super(s);
	}
}
