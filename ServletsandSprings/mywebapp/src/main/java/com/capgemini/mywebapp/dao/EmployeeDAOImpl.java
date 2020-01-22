package com.capgemini.mywebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;

public class EmployeeDAOImpl implements EmployeeDao{

	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");

	@Override
	public EmployeeInfoBean searchEmployee(int empid) {

		EntityManager em=emf.createEntityManager();
		EmployeeInfoBean eib= em.find(EmployeeInfoBean.class, empid);
		em.close();
		return eib;
		
	}

	@Override
	public EmployeeInfoBean authenticate(int empid, String password) {

	EntityManager em=emf.createEntityManager();
	
	String jpql="from EmployeeInfoBean where emp_id=:empid and password=:password";
	Query query=em.createQuery(jpql);
	query.setParameter("empid", empid);
	query.setParameter("password", password);
	
	
	EmployeeInfoBean eib=null;
	try {
		eib = (EmployeeInfoBean) query.getSingleResult();
	} catch (Exception e) {
System.err.println("NO EMPLOYEE PRESENT WITH THIS EMP ID OR WRONG PASSWORD INSERTED");
	
	}
	em.close();
	return eib;
	
	
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean eib) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(eib);
		et.commit();
		boolean add=true;
		em.close();
	return add;
	
	}

	@Override
	public boolean deleteEmployee(int empid) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		EmployeeInfoBean eb=em.find(EmployeeInfoBean.class, empid);
		et.begin();
		em.remove(eb);
		et.commit();
		boolean isdelete=true;
		
		
		if(isdelete==true)
	{
		return true;
	}
	return false;
	
	
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean eib) {
		boolean isupdated=false;
		EntityManager em=emf.createEntityManager();
		EmployeeInfoBean eibexists=em.find(EmployeeInfoBean.class, eib.getEmp_id());
		EntityTransaction et=em.getTransaction();
		if(eibexists!=null)
		{
			try {
				String newName=eib.getName().trim();
				if(newName!=null && !newName.isEmpty())
				{
					eibexists.setName(newName);
				}
				int newAge=eib.getAge();
				if(newAge>18)
				{
					eibexists.setAge(newAge);
				}
				double newSal=eib.getSalary();
				if(newSal>0)
				{
					eibexists.setSalary(newSal);
				}
				String newDesignation=eib.getDesignation().trim();
				if(newDesignation!=null && !newDesignation.isEmpty())
				{
					eibexists.setDesignation(newDesignation);
				}
				String newPasasword=eib.getPassword();
				if(newPasasword!=null && !newPasasword.isEmpty())
				{
					eibexists.setPassword(newPasasword);
				}
				et.begin();
				em.persist(eibexists);
				et.commit();
				isupdated=true;
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}
em.close();
return isupdated;


		
		
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		EntityManager em=emf.createEntityManager();

		
		String jpql="from EmployeeInfoBean";
		Query query=em.createQuery(jpql);
		List<EmployeeInfoBean> eib1=query.getResultList();
	return eib1;
	
	
	
	}
	
	
}
