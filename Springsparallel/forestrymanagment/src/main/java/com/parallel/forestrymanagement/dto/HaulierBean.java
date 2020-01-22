package com.parallel.forestrymanagement.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="haulier_details")
public class HaulierBean {
	@Id
	@Column
	private int haulierid;
	@Column
	private int	postalcode;
	@Column
	private String email;
	@Column
	private int	no;
	@Column
	private String	address1;
	@Column
	private String	address2;
	@Column
	private String town;
	@Column
	private String hauliername;
	public int getHaulierid() {
		return haulierid;
	}
	public void setHaulierid(int haulierid) {
		this.haulierid = haulierid;
	}
	public int getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getHauliername() {
		return hauliername;
	}
	public void setHauliername(String hauliername) {
		this.hauliername = hauliername;
	}
	
	
}