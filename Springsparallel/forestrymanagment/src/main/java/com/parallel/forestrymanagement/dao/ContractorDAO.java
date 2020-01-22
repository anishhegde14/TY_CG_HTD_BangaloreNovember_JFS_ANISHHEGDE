package com.parallel.forestrymanagement.dao;

import java.util.List;

import com.parallel.forestrymanagement.dto.ContractBean;

public interface ContractorDAO{

	public List<ContractBean> getAllContract();
	public List<ContractBean> getAllContractOfCustomer(int customerId);
	public boolean updateContractOfClient(ContractBean bean);
	public boolean updateContractOfScheduler(ContractBean bean);
	public boolean addContract(ContractBean contract);
	public boolean deleteContract(int contractId);
	public ContractBean findContract(int contractId);
	public List<ContractBean> getAllContractOfHaulier(int haulierId);
	public boolean updateContractid(int id);
}
