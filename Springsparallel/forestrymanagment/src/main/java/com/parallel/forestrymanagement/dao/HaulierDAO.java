package com.parallel.forestrymanagement.dao;

import java.util.List;

import com.parallel.forestrymanagement.dto.HaulierBean;

public interface HaulierDAO {

	
	public List<HaulierBean> getAllHaulier();
	public boolean updateHaulier(HaulierBean haulier);
	public boolean addHaulier(HaulierBean haulier);
	public boolean deleteHaulier(int haulierId);
	public HaulierBean findHaulier(int haulierId);


}
