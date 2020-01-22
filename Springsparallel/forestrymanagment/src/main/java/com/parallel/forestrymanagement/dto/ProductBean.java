package com.parallel.forestrymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="product_info")
public class ProductBean {

	
	@Id
	@Column
	@GeneratedValue
	private int productId;
	@Column
	private String productName;
	@Column
	private int avaliableqty;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getAvaliableqty() {
		return avaliableqty;
	}
	public void setAvaliableqty(int avaliableqty) {
		this.avaliableqty = avaliableqty;
	}


	
	
}
