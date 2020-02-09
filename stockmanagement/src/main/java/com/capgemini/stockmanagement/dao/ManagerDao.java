package com.capgemini.stockmanagement.dao;

import java.util.List;

import com.capgemini.stockmanagement.dto.ManagerBean;
import com.capgemini.stockmanagement.dto.ManagerDetails;

public interface ManagerDao {

	public boolean addManager(ManagerBean bean);

	public boolean deleteManager(int id);

	public ManagerBean findManager(int id);

	public ManagerBean findManagerByName(String name);

	public ManagerBean findManagerByCompany(int id);

	public List<ManagerBean> findAllManager();

	public boolean updateManager(ManagerBean bean);
}
