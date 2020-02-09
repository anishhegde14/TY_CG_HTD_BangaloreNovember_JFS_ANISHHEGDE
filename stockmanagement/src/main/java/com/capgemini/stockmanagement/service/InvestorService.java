package com.capgemini.stockmanagement.service;

import java.util.List;

import com.capgemini.stockmanagement.dto.InvestorBean;
import com.capgemini.stockmanagement.dto.InvestorDetails;

public interface InvestorService {
	public boolean registerInvestor(InvestorDetails bean);

	public boolean deleteInvestor(int id);

	public boolean updateInvestor(InvestorBean bean);

	public InvestorBean searchInvestor(String emailId);

	public List<InvestorBean> getAllInvestor();

	public InvestorBean searchInvestorById(int id);

}