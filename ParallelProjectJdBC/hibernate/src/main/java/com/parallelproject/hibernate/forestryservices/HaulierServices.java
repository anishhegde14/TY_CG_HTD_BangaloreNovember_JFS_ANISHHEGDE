package com.parallelproject.hibernate.forestryservices;

import java.util.List;

import com.parallelproject.hibernate.forestrybean.HaulierBean;

public interface HaulierServices {

	public List<HaulierBean> getAllHaulier();
	public boolean updateHaulier(HaulierBean haulier);
	public boolean addHaulier(HaulierBean haulier);
	public boolean deleteHaulier(int haulierId);
	public HaulierBean findHaulier(int haulierId);
	
}
