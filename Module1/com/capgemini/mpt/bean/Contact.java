package com.capgemini.mpt.bean;

public class Contact {

	
	
	private String number;
	private String name;
	private String group;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Contact [number=" + number + ", name=" + name + ", group=" + group + "]";
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
}
