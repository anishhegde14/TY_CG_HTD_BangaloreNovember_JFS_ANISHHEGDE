package com.parallel.forestrymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.parallel.forestrymanagement.dto.HaulierBean;
@Repository
public class HaulierDAOImpl implements HaulierDAO{
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public List<HaulierBean> getAllHaulier() {
		try{
			String jpql="from HaulierBean";
			EntityManager emManager=entityManagerFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			List<HaulierBean> list=query.getResultList();
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
	public boolean updateHaulier(HaulierBean haulier) {
		
		
		try{
			EntityManager emManager=entityManagerFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="update CustomerBean set customername=:name,town=:town,address1=:address1,address2=:address2,postalcode=:postal,email=:email,no=:phone where customerid=:cid";
			Query q=emManager.createQuery(jpql);
			q.setParameter("name",haulier.getHauliername());
			q.setParameter("town", haulier.getTown());
			q.setParameter("postal", haulier.getPostalcode());
			q.setParameter("email", haulier.getEmail());
			q.setParameter("phone", haulier.getNo());
			q.setParameter("address1", haulier.getAddress1());
			q.setParameter("address2", haulier.getAddress2());
			q.setParameter("cid", haulier.getHaulierid());
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
	public boolean addHaulier(HaulierBean haulier) {
		EntityTransaction transactiont=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			transactiont=entityManager.getTransaction();
			transactiont.begin();
			entityManager.persist(haulier);
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
	public boolean deleteHaulier(int haulierId) {
		try{
			EntityManager emManager=entityManagerFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="Delete from CustomerBean where haulierid=:haulierId ";
			Query query=emManager.createQuery(jpql);
			query.setParameter("haulierid",(long) haulierId);
			int result=query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if(result>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public HaulierBean findHaulier(int haulierId) {
		try{
			EntityManager eManager=entityManagerFactory.createEntityManager();
			HaulierBean haulierBean=eManager.find(HaulierBean.class, (long)haulierId);
			return haulierBean;
			}catch (Exception e) {
				e.printStackTrace();
			return null;
			}

	}
	}


