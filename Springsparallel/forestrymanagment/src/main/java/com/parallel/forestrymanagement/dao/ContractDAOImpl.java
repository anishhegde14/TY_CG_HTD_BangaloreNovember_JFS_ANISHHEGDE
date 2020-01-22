package com.parallel.forestrymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.parallel.forestrymanagement.dto.ContractBean;
@Repository
public class ContractDAOImpl implements ContractorDAO {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	
	@Override
	public List<ContractBean> getAllContract() {
		try{
			String jpql="from ContractBean";
			EntityManager emManager=entityManagerFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			List<ContractBean> list=query.getResultList();
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
	public boolean updateContractOfClient(ContractBean bean) {
	
		try{
			EntityManager emManager=entityManagerFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="update ContractBean set qty=:qty,productId=:prodid where contractno=:contract_no";
			Query q=emManager.createQuery(jpql);
			q.setParameter("qty", bean.getQty());
			q.setParameter("prodid", bean.getProductId());
			q.setParameter("contract_no", bean.getContractno());
			int result=q.executeUpdate();
			etTransaction.commit();
			emManager.close();

			if(result>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			return false;
		}
		
		
	}
	@Override
	public boolean addContract(ContractBean contract) {
		EntityManager em=entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(contract);
		et.commit();
		System.out.println("Contract Added");
		em.close();
		return true;
		
	}

	@Override
	public boolean deleteContract(int contractId) {
		try{
			EntityManager emManager=entityManagerFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="Delete from ContractBean where contractno=:contractId ";
			Query query=emManager.createQuery(jpql);
			query.setParameter("contractId",(long) contractId);
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
	public ContractBean findContract(int contractId) {
		try{
			EntityManager eManager=entityManagerFactory.createEntityManager();
			ContractBean bean=eManager.find(ContractBean.class, (long)contractId);
			return bean;
			}catch (Exception e) {
				e.printStackTrace();
			return null;
			}
		}

	@Override
	public List<ContractBean> getAllContractOfCustomer(int customerId) {
		try{
			String jpql="from ContractBean where customerid=:customerId";
			EntityManager emManager=entityManagerFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			query.setParameter("customerId", (long)customerId);
			List<ContractBean> list=query.getResultList();
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
	public List<ContractBean> getAllContractOfHaulier(int haulierId) {
		try{
			String jpql="from ContractBean where haulierId=:haulierid";
			EntityManager emManager=entityManagerFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			query.setParameter("haulierid", haulierId);
			List<ContractBean> list=query.getResultList();
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
	public boolean updateContractid(int id) {
		
		try{
			EntityManager emManager=entityManagerFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="update ContractBean set orderStatus='Delivered' where contractno=:contractno";
			Query q=emManager.createQuery(jpql);
			q.setParameter("contractno",(long)id);
			
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
	public boolean updateContractOfScheduler(ContractBean bean) {
		try{
			EntityManager emManager=entityManagerFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="update ContractBean set haulierId=:haulierId where contractno=:contract_no";
			Query q=emManager.createQuery(jpql);
			q.setParameter("haulierId", bean.getHaulierId());
			int result=q.executeUpdate();
			etTransaction.commit();
			emManager.close();

			if(result>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			return false;
		}
	}		
}
