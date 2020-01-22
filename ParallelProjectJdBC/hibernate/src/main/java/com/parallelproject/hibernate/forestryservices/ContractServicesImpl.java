package com.parallelproject.hibernate.forestryservices;

import java.util.List;

import com.parallelproject.hibernate.forestrybean.ContractBean;
import com.parallelproject.hibernate.forestrydao.ContractDAOImpl;
import com.parallelproject.hibernate.forestrydao.ContractorDAO;

public class ContractServicesImpl implements ContractServices {
	ContractorDAO dao = new ContractDAOImpl();
	

	@Override
	public List<ContractBean> getAllContract() {
		return dao.getAllContract();
	}

	@Override
	public boolean updateContract(ContractBean bean) {
		return dao.updateContract(bean);
	}

	@Override
	public boolean addContract(ContractBean contract) {
		return dao.addContract(contract);
	}

	@Override
	public boolean deleteContract(int contractId) {
		return dao.deleteContract(contractId);
	}

	@Override
	public ContractBean findContract(int contractId) {
		return dao.findContract(contractId);
	}

	@Override
	public List<ContractBean> getAllContractOfCustomer(int customerId) {
		// TODO Auto-generated method stub
		return dao.getAllContractOfCustomer(customerId);
	}

	@Override
	public List<ContractBean> getAllContractOfHaulier(int haulierId) {
		// TODO Auto-generated method stub
		return dao.getAllContractOfHaulier(haulierId);
	}

	@Override
	public boolean updateContractid(int id) {
		// TODO Auto-generated method stub
		return dao.updateContractid(id);
	}

}