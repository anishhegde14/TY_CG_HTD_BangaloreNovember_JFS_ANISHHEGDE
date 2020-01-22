package com.parallel.forestrymanagement.services;

import java.util.List;

import com.parallel.forestrymanagement.dto.ContractBean;

public interface ContractServices {
	public boolean addContract(ContractBean bean);
	public boolean deleteContract(String id);
	public boolean updateContractOfClient(ContractBean bean);
	public boolean updateContractOfScheduler(int i,int j);
	public ContractBean findContract(String id);
	public List<ContractBean> getAllContract();
	public List<ContractBean> getAllContractOfClient(String id);
	public List<ContractBean> getAllContractOfHaulier(String id);
}
