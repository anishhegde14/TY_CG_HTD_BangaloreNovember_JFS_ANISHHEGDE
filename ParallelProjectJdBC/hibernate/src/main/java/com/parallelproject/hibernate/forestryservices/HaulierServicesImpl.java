package com.parallelproject.hibernate.forestryservices;

import java.util.List;

import com.parallelproject.hibernate.forestrybean.HaulierBean;
import com.parallelproject.hibernate.forestrydao.HaulierDAO;
import com.parallelproject.hibernate.forestrydao.HaulierDAOImpl;

public class HaulierServicesImpl implements HaulierServices {
	HaulierDAO dao = new HaulierDAOImpl();

	@Override
	public List<HaulierBean> getAllHaulier() {
		return dao.getAllHaulier();
	}

	@Override
	public boolean updateHaulier(HaulierBean haulier) {
		return dao.updateHaulier(haulier);
	}

	@Override
	public boolean addHaulier(HaulierBean haulier) {
		return dao.addHaulier(haulier);
	}

	@Override
	public boolean deleteHaulier(int haulierId) {
		return dao.deleteHaulier(haulierId);
	}

	@Override
	public HaulierBean findHaulier(int haulierId) {
		return dao.findHaulier(haulierId);
	}

}
