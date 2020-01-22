package com.parallel.forestrymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.parallel.forestrymanagement.dto.ClientBean;
@Repository
public class ClientDAOImpl implements ClientDao{
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	@Override
	public List<ClientBean> getAllClient() {
		try{
			String jpql="from ClientBean";
			EntityManager emManager=entityManagerFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			List<ClientBean> list=query.getResultList();
			System.out.println(list);
			emManager.close();
			return list;
			
		}catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
		}

	return null;
	
	}

	@Override
	public boolean updateClient(ClientBean client) {
		try{
			EntityManager emManager=entityManagerFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="update ClientBean set clientname=:name,town=:town,password=:password,address1=:address1,address2=:address2,postalcode=:postal,email=:email,no=:phone where clientid=:cid";
			Query q=emManager.createQuery(jpql);
			q.setParameter("name",client.getClientname());
			q.setParameter("town", client.getTown());
			q.setParameter("postal", client.getPostalcode());
			q.setParameter("email", client.getEmail());
			q.setParameter("phone", client.getNo());
			q.setParameter("address1", client.getAddress1());
			q.setParameter("address2", client.getAddress2());
			q.setParameter("cid", client.getClientid());
			q.setParameter("password", client.getPassword());
			int result=q.executeUpdate();
			etTransaction.commit();
			emManager.close();

			if(result>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addClient(ClientBean client) {
	
		EntityTransaction transactiont=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			transactiont=entityManager.getTransaction();
			transactiont.begin();
			entityManager.persist(client);
			transactiont.commit();
			entityManager.close();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			transactiont.rollback();
			return false;
		}
	}
	
	
	
	@Override
	public boolean deleteClient(int clientId) {
		try{
			EntityManager emManager=entityManagerFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="delete from ClientBean where clientid=:clientId ";
			Query query=emManager.createQuery(jpql);
			query.setParameter("clientId", clientId);
			int result=query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if(result>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("There is problem in deleting Client: "+message);
			return false;
		}
	}

	@Override
	public ClientBean findClient(int clientId) {
		try{
			EntityManager eManager=entityManagerFactory.createEntityManager();
			ClientBean clientBean=eManager.find(ClientBean.class, clientId);
			return clientBean;
			}catch (Exception e) {
				e.printStackTrace();
			return null;
			}

	}

}
