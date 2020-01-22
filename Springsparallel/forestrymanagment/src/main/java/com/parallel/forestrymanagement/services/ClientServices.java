package com.parallel.forestrymanagement.services;

import java.util.List;

import com.parallel.forestrymanagement.dto.ClientBean;

public interface ClientServices {


public boolean addClient(ClientBean bean);
public boolean deleteClient(String id);
public boolean updateClient(ClientBean bean);
public ClientBean findClient(String id);
public List<ClientBean> getAllClient();
}
