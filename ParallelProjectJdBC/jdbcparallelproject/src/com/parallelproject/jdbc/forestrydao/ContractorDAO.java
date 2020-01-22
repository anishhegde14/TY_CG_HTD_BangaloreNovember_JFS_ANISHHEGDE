package com.parallelproject.jdbc.forestrydao;

import java.util.List;

import com.parallelproject.jdbc.forestrybean.ContractBean;

public interface ContractorDAO{

	public List<ContractBean> getAllContract();
	public List<ContractBean> getAllContractOfCustomer(int customerId);
	public boolean updateContract(ContractBean bean);
	public boolean addContract(ContractBean contract);
	public boolean deleteContract(int contractId);
	public ContractBean findContract(int contractId);
	public List<ContractBean> getAllContractOfHaulier(int haulierId);
	public boolean updateContractid(int id);
	
}
