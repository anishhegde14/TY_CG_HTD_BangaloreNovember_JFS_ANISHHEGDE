package com.parallelproject.jdbc.forestryservices;

import java.util.List;

import com.parallelproject.jdbc.forestrybean.HaulierBean;

public interface HaulierServices {

	public List<HaulierBean> getAllHaulier();
	public boolean updateHaulier(HaulierBean haulier);
	public boolean addHaulier(HaulierBean haulier);
	public boolean deleteHaulier(int haulierId);
	public HaulierBean findHaulier(int haulierId);
	
	
}