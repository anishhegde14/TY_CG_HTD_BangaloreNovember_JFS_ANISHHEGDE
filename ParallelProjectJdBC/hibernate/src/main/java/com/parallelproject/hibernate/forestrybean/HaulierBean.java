package com.parallelproject.hibernate.forestrybean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="haulier_details")
public class HaulierBean {
	@Column(name="postal_code")
	private long	postalcode;
	@Column
	private String email;
	@Column
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
	@Column(name="haulier_name")
	private String hauliername;
	@Id
	@Column(name="haulier_id")
	private long haulierid;
	public long getHaulierid() {
		return haulierid;
	}
	public void setHaulierid(long haulierid) {
		this.haulierid = haulierid;
	}
	@Column
	private String	address1;
	@Column
	private String	address2;
	@Column
	private String town;
}
