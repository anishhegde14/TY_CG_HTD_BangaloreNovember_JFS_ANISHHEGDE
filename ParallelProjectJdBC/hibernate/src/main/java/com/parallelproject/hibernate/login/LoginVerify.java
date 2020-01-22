package com.parallelproject.hibernate.login;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.parallelproject.hibernate.forestrybean.ContractBean;
import com.parallelproject.hibernate.forestrybean.LoginDetailsBean;

public class LoginVerify {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	
	public int type(String name, int id) {

		int key = 0;
		
		LoginDetailsBean loginBean=new LoginDetailsBean();
		loginBean.setId(id);
		loginBean.setName(name);
		LoginDetailsBean loginDetailsBean1=new LoginDetailsBean();
		loginDetailsBean1=entityManager.find(LoginDetailsBean.class, id);
		if((loginDetailsBean1.getId()==id) && name.equals(loginDetailsBean1.getName()))
		{
			
			return loginDetailsBean1.getType();
		}
		
		return 0;

	}

	public int validId(int id)
		{
		try{
			EntityManagerFactory eMFactory=Persistence.createEntityManagerFactory("Test");
			EntityManager eManager=eMFactory.createEntityManager();
			LoginDetailsBean bean=eManager.find(LoginDetailsBean.class, id);
			return bean.getId();
			}catch (Exception e) {
				e.printStackTrace();
			return 0;
			}
			
			}
		
		
	
	public String validName(String name)
	{
		
		try{
			EntityManagerFactory eMFactory=Persistence.createEntityManagerFactory("Test");
			EntityManager eManager=eMFactory.createEntityManager();
			LoginDetailsBean bean=eManager.find(LoginDetailsBean.class, name);
			return bean.getName();
			}catch (Exception e) {
				e.printStackTrace();
			return null;
			}		
		}
	
	

	public boolean addLoginCredentials(int id,String name,int key) {
		LoginDetailsBean people=new LoginDetailsBean();
		people.setId(id);
		people.setName(name);
		people.setType(key);
		
		EntityTransaction transactiont=null;
		try {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			transactiont=entityManager.getTransaction();
			transactiont.begin();
			entityManager.persist(people);
			transactiont.commit();
			entityManager.close();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			transactiont.rollback();
			return false;
		}
	
	
	}
	public boolean deleteContract(int id) {
		
		try{
			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("Test");
			EntityManager emManager=emFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="Delete from LoginDetailsBean where id=:id ";
			Query query=emManager.createQuery(jpql);
			query.setParameter("id",id);
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

	
		}

