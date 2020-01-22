package com.parallel.forestrymanagement.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="client_details")
public class ClientBean {

	@Id
	@Column
	private int clientid;
	@Column
	private String clientname;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String	no;
	@Column
	private String town;
	@Column
	private String	address1;
	@Column
	private String	address2;
	@Column
	private int	postalcode;
	@Column
	private String password;
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
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
	public int getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ClientBean [clientid=" + clientid + ", clientname=" + clientname + ", email=" + email + ", no=" + no
				+ ", town=" + town + ", address1=" + address1 + ", address2=" + address2 + ", postalcode=" + postalcode
				+ ", password=" + password + "]";
	}
	
}