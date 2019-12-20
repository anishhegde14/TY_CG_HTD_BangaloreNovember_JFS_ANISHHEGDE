package com.capgemini.springcore.beans;

public class Hello {

	
	
	public Hello(String message, int count) {
		super();
		this.message = message;
		this.count = count;
	}

	private String message;
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
