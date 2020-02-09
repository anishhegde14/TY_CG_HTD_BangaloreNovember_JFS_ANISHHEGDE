package com.capgemini.stockmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagement.dto.CompanyBean;
import com.capgemini.stockmanagement.dto.InvestorBean;
import com.capgemini.stockmanagement.dto.InvestorDetails;
import com.capgemini.stockmanagement.dto.LoginBean;
import com.capgemini.stockmanagement.exception.InvestorException;
import com.capgemini.stockmanagement.exception.LoginException;

@Repository
public class InvestorDaoImpl implements InvestorDao {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean registerInvestor(InvestorDetails bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new InvestorException("Email already exists");
		}
	}

	@Override
	public boolean deleteInvestor(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		InvestorBean bean = manager.find(InvestorBean.class, id);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		} else {
			throw new InvestorException("Investor Not Found");
		}
	}

	@Override
	public boolean updateInvestor(InvestorBean bean) {
		try {
			EntityManager emManager = factory.createEntityManager();
			EntityTransaction etTransaction = emManager.getTransaction();
			etTransaction.begin();
			System.out.println("input from fe" + bean);
			String jpql = "update InvestorBean set investorName=:investorName,emailId=:emailId,url=:url,maxInvest=:maxInvest where id=:id";
			Query q = emManager.createQuery(jpql);
			q.setParameter("id", bean.getId());
			q.setParameter("investorName", bean.getInvestorName());
			q.setParameter("emailId", bean.getEmailId());
			q.setParameter("url", bean.getUrl());
			q.setParameter("maxInvest", bean.getMaxInvest());

			int result = q.executeUpdate();
			etTransaction.commit();
			emManager.close();

			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public InvestorBean searchInvestor(String emailId) {
		try {

			EntityManager entityManager = factory.createEntityManager();
			String jpql = "from InvestorBean where emailId=:emailId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("emailId", emailId);
			InvestorBean bean2 = (InvestorBean) query.getSingleResult();
			entityManager.close();
			System.out.println(bean2);
			return bean2;
		} catch (Exception e) {
			return new InvestorBean();
		}

	}

	@Override
	public List<InvestorBean> getAllInvestor() {
		try {

			EntityManager entityManager = factory.createEntityManager();
			String jpql = "from InvestorBean";
			Query query = entityManager.createQuery(jpql);
			List<InvestorBean> bean = query.getResultList();
			entityManager.close();
			return bean;
		} catch (Exception e) {
			throw new InvestorException("Investor Id Not Found");
		}
	}

	@Override
	public InvestorBean searchInvestorById(int id) {
		try {
			EntityManager entityManager = factory.createEntityManager();
			InvestorBean bean = entityManager.find(InvestorBean.class, id);
			entityManager.close();
			return bean;
		} catch (Exception e) {
			return new InvestorBean();
		}
	}
}