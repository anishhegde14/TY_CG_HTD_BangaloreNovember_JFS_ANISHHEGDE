package com.parallelproject.jdbc.forestrybean;

public class HaulierBean {

	private long	postalcode;
	private String email;
	private long	no;
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
	public String getHauliername() {
		return hauliername;
	}
	public void setHauliername(String hauliername) {
		this.hauliername = hauliername;
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
	private String hauliername;
	private long haulierid;
	public long getHaulierid() {
		return haulierid;
	}
	public void setHaulierid(long haulierid) {
		this.haulierid = haulierid;
	}
	private String	address1;
	private String	address2;
	private String town;
}
