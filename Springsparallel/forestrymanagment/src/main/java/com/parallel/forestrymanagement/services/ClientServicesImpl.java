package com.parallel.forestrymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parallel.forestrymanagement.dao.ClientDao;
import com.parallel.forestrymanagement.dao.LoginDao;
import com.parallel.forestrymanagement.dao.LoginDaoImpl;
import com.parallel.forestrymanagement.dto.ClientBean;
import com.parallel.forestrymanagement.dto.LoginDetailsBean;
import com.parallel.forestrymanagement.exception.CustomerException;

@Service
public class ClientServicesImpl implements ClientServices {
	@Autowired
	public ClientDao dao;
	@Autowired
	LoginServices loginDAO;

	@Override
	public boolean addClient(ClientBean bean) {
		
		if(loginDAO.addLoginCredentials(bean)) {
		LoginDetailsBean loginBean = loginDAO.findCredentials(bean.getEmail());
		bean.setClientid((int) loginBean.getId());

		System.out.println(bean.getClientid());
		try {
			if (dao.addClient(bean)) {
				return true;
			}
		} catch (Exception e) {

			loginDAO.deleteLoginCredentials(String.valueOf(bean.getClientid()));
			return false;
		}}
		return false;
	}

	@Override
	public boolean deleteClient(String id) {

		
			try{

				int idValue=Integer.parseInt(id);
				if(dao.findClient(idValue).getClientid()!=0) {
				if(dao.deleteClient(idValue)) {
				loginDAO.deleteLoginCredentials(id);
			return true;
			}
				}
				else {
					throw new CustomerException("Customer Not Found");
				}
				return false;
			}
			catch(Exception e)
	{
		return false;
	}
}

	

	@Override
	public boolean updateClient(ClientBean bean) {
		if (dao.findClient(bean.getClientid()).getClientid() != 0) {
			if (dao.updateClient(bean)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ClientBean findClient(String id) {
		try {
			int idValue = Integer.parseInt(id);
			ClientBean bean = dao.findClient(idValue);
			if (bean.getClientid() != 0) {
				System.out.println(bean.getClientid());
				return bean;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public List<ClientBean> getAllClient() {

		return dao.getAllClient();
	}

}
