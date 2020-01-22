package com.parallel.forestrymanagement.dao;

import java.util.List;

import com.parallel.forestrymanagement.dto.ClientBean;

public interface ClientDao {

	public List<ClientBean> getAllClient();
	public boolean updateClient(ClientBean client);
	public boolean addClient(ClientBean client);
	public boolean deleteClient(int clientId);
	public ClientBean findClient(int clientId);
	
	
	
	
}
