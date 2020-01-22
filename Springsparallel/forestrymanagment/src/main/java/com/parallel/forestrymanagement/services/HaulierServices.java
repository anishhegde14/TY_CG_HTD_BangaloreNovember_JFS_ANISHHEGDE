package com.parallel.forestrymanagement.services;

import java.util.List;

import com.parallel.forestrymanagement.dto.HaulierBean;

public interface HaulierServices {

	
	public boolean addHaulier(HaulierBean bean);
	public boolean deleteHaulier(String id);
	public boolean updateHaulier(HaulierBean bean);
	public HaulierBean findHaulier(String id);
	public List<HaulierBean> seeAllHauliers();
}
