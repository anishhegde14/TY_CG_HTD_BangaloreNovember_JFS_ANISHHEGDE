package com.parallel.forestrymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parallel.forestrymanagement.dao.HaulierDAO;
import com.parallel.forestrymanagement.dto.ClientBean;
import com.parallel.forestrymanagement.dto.HaulierBean;
@Service
public class HaulierServicesImpl implements HaulierServices{
	@Autowired
	private HaulierDAO dao;
	private LoginServices services=new LoginServicesImpl() {
		
	};
	@Override
	public boolean addHaulier(HaulierBean bean) {
		if(services.findLoginCredentials(bean.getHaulierid()).getId()!=0)
		{
			dao.addHaulier(bean);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteHaulier(String id) {
		int id1=Integer.parseInt(id);
		if(dao.findHaulier(id1).getHaulierid()!=0) {
			dao.deleteHaulier(id1);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateHaulier(HaulierBean bean) {
		if(bean.getHaulierid()!=0) {
			dao.updateHaulier(bean);
			return true;
		}
		
		return false;
	}

	@Override
	public HaulierBean findHaulier(String id) {
		int id1=Integer.parseInt(id);
		if(dao.findHaulier(id1).getHaulierid()!=0) {
			return dao.findHaulier(id1);
		}
		return null;
	}

	@Override
	public List<HaulierBean> seeAllHauliers() {
		return dao.getAllHaulier();
	}

	
	
}
