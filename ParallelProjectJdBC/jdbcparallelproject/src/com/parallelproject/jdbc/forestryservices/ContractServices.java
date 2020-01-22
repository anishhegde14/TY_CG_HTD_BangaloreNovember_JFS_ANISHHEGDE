package com.parallelproject.jdbc.forestryservices;

import java.util.List;

import com.parallelproject.jdbc.forestrybean.ContractBean;

public interface ContractServices {
	public List<ContractBean> getAllContract();
	public boolean updateContract(ContractBean bean);
	public boolean addContract(ContractBean contract);
	public boolean deleteContract(int contractId);
	public ContractBean findContract(int contractId);
	public List<ContractBean> getAllContractOfCustomer(int customerId);
	public List<ContractBean> getAllContractOfHaulier(int haulierId);
	public boolean updateContractid(int id);
}
