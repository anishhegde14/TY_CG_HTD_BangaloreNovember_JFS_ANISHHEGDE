package com.capgemini.stockmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "investor")
public class InvestorBean {
	@Id
	@Column
	@GeneratedValue
	private int id;
	@Column
	private String investorName;
	@Column
	private String emailId;
	@Column
	private String url;
	@Column
	private double maxInvest;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInvestorName() {
		return investorName;
	}

	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getMaxInvest() {
		return maxInvest;
	}

	public void setMaxInvest(double maxInvest) {
		this.maxInvest = maxInvest;
	}

	@Override
	public String toString() {
		return "InvestorBean [id=" + id + ", investorName=" + investorName + ", emailId=" + emailId + ", url=" + url
				+ ", maxInvest=" + maxInvest + "]";
	}
}