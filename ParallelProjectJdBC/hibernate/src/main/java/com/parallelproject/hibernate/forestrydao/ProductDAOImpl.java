package com.parallelproject.hibernate.forestrydao;

import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.parallelproject.hibernate.forestrybean.ContractBean;
import com.parallelproject.hibernate.forestrybean.CustomerBean;
import com.parallelproject.hibernate.forestrybean.ProductBean;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public List<ProductBean> getAllProducts() {
		try {
			String jpql = "from ProductBean";
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Test");
			EntityManager emManager = emFactory.createEntityManager();
			Query query = emManager.createQuery(jpql);
			List<ProductBean> list = query.getResultList();
			System.out.println(list);
			emManager.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			String message = e.getMessage();
		}

		return null;

	}

	@Override
	public boolean addProducts(ProductBean product) {

		EntityTransaction transactiont = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			transactiont = entityManager.getTransaction();
			transactiont.begin();
			entityManager.persist(product);
			transactiont.commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transactiont.rollback();
			return false;
		}
	}

	@Override
	public boolean deleteProducts(int id) {

		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Test");
			EntityManager emManager = emFactory.createEntityManager();
			EntityTransaction etTransaction = emManager.getTransaction();
			etTransaction.begin();
			String jpql = "Delete from ProductBean where productId=:product_id ";
			Query query = emManager.createQuery(jpql);
			query.setParameter("product_id", id);
			int result = query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			String message = e.getMessage();
			System.out.println("There is problem in deleting Customer: " + message);
			return false;
		}

	}

	@Override
	public ProductBean findProduct1(String id) {

		try {
			EntityManagerFactory eMFactory = Persistence.createEntityManagerFactory("Test");
			EntityManager eManager = eMFactory.createEntityManager();
			String jpql = "from ProductBean where productName=:productName";
			Query query = eManager.createQuery(jpql);
			query.setParameter("productName", id);
			System.out.println(query.getSingleResult());
			ProductBean bean = (ProductBean) query.getSingleResult();
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("next linee");
			return null;
		}

	}

	@Override
	public ProductBean findProduct(int id) {
		try {
			EntityManagerFactory eMFactory = Persistence.createEntityManagerFactory("Test");
			EntityManager eManager = eMFactory.createEntityManager();
			ProductBean bean = eManager.find(ProductBean.class, id);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean updateProduct(ProductBean product, int id) {
		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Test");
			EntityManager emManager = emFactory.createEntityManager();
			EntityTransaction etTransaction = emManager.getTransaction();
			etTransaction.begin();
			String jpql = "update ProductBean set productName=:value where productId=:productId";
			Query q = emManager.createQuery(jpql);
			q.setParameter("value", product.getProductName());
			q.setParameter("productId", id);

			int result = q.executeUpdate();
			etTransaction.commit();
			emManager.close();

			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			String message = e.getMessage();
			return false;
		}

	}

}
