package com.parallelproject.hibernate.forestrybean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class LoginDetailsBean {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "LoginDetailsBean [id=" + id + ", name=" + name + ", type=" + type + "]";
	}



}
