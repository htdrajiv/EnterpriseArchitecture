package com.cuisine_mart.order.exception;

public class FoodNotFound extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 655347096931818482L;
	public FoodNotFound() {
		super();
	}
	public FoodNotFound(String s) {
		super(s);
	}
}
