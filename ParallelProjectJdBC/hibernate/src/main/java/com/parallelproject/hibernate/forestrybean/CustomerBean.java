package com.parallelproject.hibernate.forestrybean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_details")
public class CustomerBean {

	@Id
	@Column(name="CustomerID")
	private long customerid;
	@Column(name="Customer_name")
	private String customername;
	@Column(name="emailid")
	private String email;
	@Column(name="phone_number")
	private long	no;
	@Column(name="town")
	private String town;
	@Column(name="street_address1")
	private String	address1;
	@Column(name="street_address2")
	private String	address2;
	@Column(name="postal_code")
	private long	postalcode;
	
	
	
	@Override
	public String toString() {
		return "CustomerDetails [customerid=" + customerid + ", customername=" + customername + ", address1=" + address1
				+ ", address2=" + address2 + ", town=" + town + ", postalcode=" + postalcode + ", email=" + email
				+ ", no=" + no + "]";
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
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
	public long getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(long postalcode) {
		this.postalcode = postalcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	
	
	
}
