package com.parallelproject.hibernate.forestrydao;

import java.util.List;

import com.parallelproject.hibernate.forestrybean.HaulierBean;

public interface HaulierDAO {

	
	public List<HaulierBean> getAllHaulier();
	public boolean updateHaulier(HaulierBean haulier);
	public boolean addHaulier(HaulierBean haulier);
	public boolean deleteHaulier(int haulierId);
	public HaulierBean findHaulier(int haulierId);


}
