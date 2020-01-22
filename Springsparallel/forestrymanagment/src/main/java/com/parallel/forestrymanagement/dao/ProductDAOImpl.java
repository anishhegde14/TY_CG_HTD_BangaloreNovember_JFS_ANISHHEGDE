package com.parallel.forestrymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.parallel.forestrymanagement.dto.ProductBean;
@Repository
public class ProductDAOImpl implements ProductDAO {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	@Override
	public List<ProductBean> getAllProducts() {
		try {
			String jpql = "from ProductBean";
			EntityManager emManager = entityManagerFactory.createEntityManager();
			Query query = emManager.createQuery(jpql);
			@SuppressWarnings("unchecked")
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
			EntityManager emManager = entityManagerFactory.createEntityManager();
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
			EntityManager eManager = entityManagerFactory.createEntityManager();
			String jpql = "from ProductBean where productName=:productName";
			Query query = eManager.createQuery(jpql);
			query.setParameter("productName", id);
			ProductBean bean = (ProductBean) query.getSingleResult();
			return bean;
		} catch (NoResultException ne) {
			
			return null;
		}

	}

	@Override
	public ProductBean findProduct(int id) {
		try {
			EntityManager eManager = entityManagerFactory.createEntityManager();
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
			EntityManager emManager = entityManagerFactory.createEntityManager();
			EntityTransaction etTransaction = emManager.getTransaction();
			etTransaction.begin();
			String jpql = "update ProductBean set avaliableqty=:avaliableqty,productName=:value where productId=:productId";
			Query q = emManager.createQuery(jpql);
			q.setParameter("value", product.getProductName());
			q.setParameter("productId", id);
			q.setParameter("avaliableqty", product.getAvaliableqty());

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
