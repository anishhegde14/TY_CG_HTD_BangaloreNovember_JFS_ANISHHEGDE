package com.parallelproject.hibernate.forestrydao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.parallelproject.hibernate.forestrybean.CustomerBean;

public class ForestryCustomerDAOImpl implements ForestryCustomerDao{
	public ForestryCustomerDAOImpl() {
	
	

}
	@Override
	public List<CustomerBean> getAllCustomer() {
		try{
			String jpql="from CustomerBean";
			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("Test");
			EntityManager emManager=emFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			List<CustomerBean> list=query.getResultList();
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
	public boolean updateCustomer(CustomerBean customer) {
		try{
			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("Test");
			EntityManager emManager=emFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="update CustomerBean set customername=:name,town=:town,address1=:address1,address2=:address2,postalcode=:postal,email=:email,no=:phone where customerid=:cid";
			Query q=emManager.createQuery(jpql);
			q.setParameter("name",customer.getCustomername());
			q.setParameter("town", customer.getTown());
			q.setParameter("postal", customer.getPostalcode());
			q.setParameter("email", customer.getEmail());
			q.setParameter("phone", customer.getNo());
			q.setParameter("address1", customer.getAddress1());
			q.setParameter("address2", customer.getAddress2());
			q.setParameter("cid", customer.getCustomerid());
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
	public boolean addCustomer(CustomerBean customer) {
	
		EntityTransaction transactiont=null;
		try {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			transactiont=entityManager.getTransaction();
			transactiont.begin();
			entityManager.persist(customer);
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
	public boolean deleteCustomer(int customerId) {
		try{
			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("Test");
			EntityManager emManager=emFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="Delete from CustomerBean where customerid=:customerId ";
			Query query=emManager.createQuery(jpql);
			query.setParameter("customerId",(long) customerId);
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
			System.out.println("There is problem in deleting Customer: "+message);
			return false;
		}
	}

	@Override
	public CustomerBean findCustomer(int customerId) {
		try{
			EntityManagerFactory eMFactory=Persistence.createEntityManagerFactory("Test");
			EntityManager eManager=eMFactory.createEntityManager();
			CustomerBean customerBean=eManager.find(CustomerBean.class, (long)customerId);
			return customerBean;
			}catch (Exception e) {
				e.printStackTrace();
			return null;
			}

	}

}
