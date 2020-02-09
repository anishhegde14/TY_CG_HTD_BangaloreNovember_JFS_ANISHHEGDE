package com.capgemini.stockmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagement.dto.CompanyBean;
import com.capgemini.stockmanagement.dto.InvestorBean;
import com.capgemini.stockmanagement.dto.StockInfoBean;
import com.capgemini.stockmanagement.exception.CompanyException;
import com.capgemini.stockmanagement.exception.InvestorException;
import com.capgemini.stockmanagement.exception.LoginException;
import com.capgemini.stockmanagement.exception.StockException;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addCompany(CompanyBean bean) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(bean);
			entityTransaction.commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			throw new CompanyException("Company  Already Exists");
		}

	}

	@Override
	public boolean deleteCompany(int id) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		CompanyBean bean = manager.find(CompanyBean.class, id);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		} else {
			throw new CompanyException("companyId Not Found");
		}
	}

	@Override
	public CompanyBean findCompany(int id) {
		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from CompanyBean where companyId=:id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			CompanyBean bean2 = (CompanyBean) query.getSingleResult();
			return bean2;
		} catch (Exception e) {
			return new CompanyBean();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyBean> getAllCompany() {

		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from CompanyBean";
			Query query = entityManager.createQuery(jpql);
			List<CompanyBean> bean = query.getResultList();
			entityManager.close();
			return bean;
		} catch (Exception e) {
			throw new LoginException("User Id Not Found");
		}
	}

	@Override
	public CompanyBean findCompanyByName(String name) {
		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from CompanyBean where name=:name";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("name", name);
			CompanyBean bean = (CompanyBean) query.getSingleResult();
			return bean;
		} catch (Exception e) {
			CompanyBean bean = new CompanyBean();
			bean.setCompanyName("");
			return bean;
		}
	}

	@Override
	public boolean updateCompany(CompanyBean bean) {

		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CompanyBean bean2 = entityManager.find(CompanyBean.class, bean.getCompanyId());
			bean2.setCompanyName(bean.getCompanyName());
			bean2.setCompanyWebsite(bean.getCompanyWebsite());
			bean2.setHeadQuarters(bean.getHeadQuarters());
			bean2.setVolume(bean.getVolume());
			bean2.setIndustry(bean.getIndustry());
			bean2.setLogo(bean.getLogo());
			bean2.setMaxStock(bean.getMaxStock());
			bean2.setRevenue(bean.getRevenue());
			entityTransaction.commit();
			entityManager.close();

			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
