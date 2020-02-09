package com.capgemini.stockmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagement.dto.TransactionBean;
import com.capgemini.stockmanagement.dto.TransactionHistory;
import com.capgemini.stockmanagement.exception.LoginException;
import com.capgemini.stockmanagement.exception.StockException;

@Repository
public class TransactionHistoryDaoImpl implements TransactionHistoryDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addTransaction(TransactionHistory bean) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(bean);
			entityTransaction.commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			throw new StockException("Transaction Already Exists!!!");
		}
	}

	@Override
	public List<TransactionHistory> viewAllTransaction() {
		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from TransactionHistory";
			Query query = entityManager.createQuery(jpql);
			List<TransactionHistory> bean = query.getResultList();
			entityManager.close();
			return bean;
		} catch (Exception e) {
			throw new LoginException("User Id Not Found");
		}
	}

}
