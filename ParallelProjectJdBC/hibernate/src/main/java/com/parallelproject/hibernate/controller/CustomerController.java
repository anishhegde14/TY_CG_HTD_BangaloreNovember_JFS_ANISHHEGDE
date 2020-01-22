package com.parallelproject.hibernate.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.parallelproject.hibernate.forestrybean.ContractBean;
import com.parallelproject.hibernate.forestrybean.CustomerBean;
import com.parallelproject.hibernate.forestrybean.ProductBean;
import com.parallelproject.hibernate.forestryservices.ContractServices;
import com.parallelproject.hibernate.forestryservices.ContractServicesImpl;
import com.parallelproject.hibernate.forestryservices.CustomerServices;
import com.parallelproject.hibernate.forestryservices.CustomerServicesImpl;
import com.parallelproject.hibernate.forestryservices.HaulierServices;
import com.parallelproject.hibernate.forestryservices.HaulierServicesImpl;
import com.parallelproject.hibernate.forestryservices.ProductServices;
import com.parallelproject.hibernate.forestryservices.ProductServicesImpl;

public class CustomerController {
	static ProductServices productservices = new ProductServicesImpl();
	static ContractServices contractServices = new ContractServicesImpl();
	HaulierServices haulierServices=new HaulierServicesImpl();
	static Scanner sc=new Scanner(System.in);
	public static long isNoValid() {
		boolean b=true;
		while(b) {
			try {
				Scanner sc=new Scanner(System.in);
				int number=sc.nextInt();
				b=false;
				return number;
			}
			catch(Exception e) {
				System.out.println("Enter valid value!!!");
			}
		}
				
		return 0;
	}
	public static int isProdValid() {
		System.out.println("Choose Products from this list");
		
		List<ProductBean> product = productservices.getAllProducts();
		for (ProductBean productBean : product) {
			System.out.print(productBean.getProductId() + ":");
			System.out.println(productBean.getProductName());
		}

		
		boolean a=true;
		int productid = 0;
		while (a) {

			System.out.println("Enter Product Id");
			int prodid = (int) isNoValid();
			if (productservices.findProduct(prodid) != null) {
				a = false;
				productid = prodid;
			}
			else {
				System.out.println("Enter Valid Id");
			}
		}
		return productid;

		
		
	}

	
	
	public void customerControl(int id)
	{
		
		CustomerServices service = new CustomerServicesImpl();
		CustomerBean customer = service.findCustomer(id);
		System.out.println("Welcome Customer " + customer.getCustomername());
		System.out.println("Please Select Any Of The Action Below");
		System.out.println("Press 1 to Add An Order");
		System.out.println("Press 2 to Update An Order");
		System.out.println("Press 3 to Delete An Order");
		System.out.println("Press 4 to Find  A order");
		int choice =(int) isNoValid();

		switch (choice) {
		case 1:boolean c=true;
		long contractid =0;
			while(c) {
				System.out.println("Enter ContractId");
				long contractid1 = isNoValid();;
				if(contractServices.findContract((int) contractid1)==null)
				{
					c=false;
					contractid=contractid1;
				}
				else
				{
					System.out.println("ContractId already exists!!!Please re-enter the ContractId");
				}
			
			}
			System.out.println("Choose Products from this list");
			int productid=isProdValid();
						System.out.println("Enter Quantity");
			int qty = (int) isNoValid();
			LocalDate date = LocalDate.now();
			date = date.plusDays(30);
			long haulier=0;
			boolean isValid3=true;
			while(isValid3) {
			try {
				System.out.println("Enter Haulier");
			Scanner sc=new Scanner(System.in);
				int choice2=(int) isNoValid();
				if(haulierServices.findHaulier(choice2)!=null)
				{
				haulier=choice2;
				isValid3=false;}
				else {
					System.out.println("Enter Valid Input");
				}
			} catch (Exception e) {
				System.out.println("Invalid Input!!!!");
			}}

			System.out.println(date.getDayOfWeek());
		
			ContractBean contract = new ContractBean();
			contract.setContractno(contractid);
			contract.setCustomerid(customer.getCustomerid());
			contract.setHaulid(haulier);
			contract.setProdid(productid);
			contract.setQty(qty);
			contract.setDate(date);
			contract.setDay(date.getDayOfWeek().name());
			contract.setOrderStatus("Ordered");

			if (contractServices.addContract(contract)) {
				System.out.println("Order Placed Successfully");
				System.out.println("Thank You for placing the order and Your Order will be delivered " + "within "
						+ date + " " + date.getDayOfWeek());
			}

			break;
		case 2:System.out.println("Enter The Order You Want to Update");
				
				System.out.println("Enter the Column Name You Want to Update");
				List<ContractBean> contractList=contractServices.getAllContractOfCustomer((int)customer.getCustomerid());
				for (ContractBean contractBean : contractList) {
					System.out.print("ContractId:"+contractBean.getContractno());
					System.out.println("Delivery Date:"+contractBean.getDate());
					System.out.println("Product ID:"+contractBean.getProdid());
					System.out.println("Quantity:"+contractBean.getQty());
					System.out.println("Day:"+contractBean.getDay());
					System.out.println("HaulierID:"+contractBean.getHaulid());
					System.out.println("Order Status:"+contractBean.getOrderStatus());
					System.out.println("-------------------------------------------------------------");
				}
				System.out.println("ENTER ORDER NO YOU WANT TO UPDATE");
				int no=0;
				boolean b=true;
				while(b) {
					no=(int) isNoValid();
					ContractBean bean=contractServices.findContract(no);
					if(bean.getCustomerid()==customer.getCustomerid())
					{
						b=false;
					}
					else
					{
						System.out.println("Enter Valid Order Id");
					}
					
				}
				System.out.println("Enter Product Id");
				System.out.println("Choose Products from this list");
				int productid1=isProdValid();
							System.out.println("Enter Quantity");
				int qty1 = (int) isNoValid();
				long haulier1=0;
				boolean isValid31=true;
				while(isValid31) {
				try {
					System.out.println("Enter Haulier");
				Scanner sc=new Scanner(System.in);
					int choice2=(int) isNoValid();
					if(haulierServices.findHaulier(choice2)!=null)
					{
					haulier1=choice2;
					isValid31=false;}
					else {
						System.out.println("Enter Valid Input");
					}
				} catch (Exception e) {
					System.out.println("Invalid Input!!!!");
				}}
				ContractBean contractupdate=new ContractBean();
				contractupdate.setContractno(no);
				contractupdate.setHaulid(haulier1);
				contractupdate.setProdid(productid1);
				contractupdate.setQty(qty1);
				
				contractServices.updateContract(contractupdate);
				
				
				break;
		case 3:System.out.println("Enter The Order You Want to Delete");
		List<ContractBean> contractListd=contractServices.getAllContractOfCustomer((int)customer.getCustomerid());
		for (ContractBean contractBean : contractListd) {
			System.out.print("ContractId:"+contractBean.getContractno());
			System.out.println("Delivery Date:"+contractBean.getDate());
			System.out.println("Product ID:"+contractBean.getProdid());
			System.out.println("Quantity:"+contractBean.getQty());
			System.out.println("Day:"+contractBean.getDay());
			System.out.println("HaulierId:"+contractBean.getHaulid());
			System.out.println("order Status="+contractBean.getOrderStatus());
			System.out.println("-------------------------------------------------------------");
			
		}
		System.out.println("Enter the order no you want to delete");
		boolean a=true;
		int orderno=0;
		while(a) {
		try {
			Scanner sc=new Scanner(System.in);
			int order = sc.nextInt();
			ContractBean beanDelete = contractServices.findContract(order);
			if (beanDelete.getCustomerid() == customer.getCustomerid()) {
				a = false;
				orderno = order;
			} else {
				System.out.println("Enter Valid Order Id");
			} 
		} catch (Exception e) {
			System.out.println("Enter Valid Order Id");
		}
		}
		contractServices.deleteContract(orderno);
		System.out.println("Order Deleted Successfully");
		
				break;
		case 4:System.out.println("Enter The Order You Want to Find");
			boolean b1=true;
			while(b1) {
				int  contractId=sc.nextInt();
				ContractBean contractBean=contractServices.findContract(contractId);
			if(contractBean.getCustomerid()==customer.getCustomerid())
			{				
			System.out.print("ContractId:"+contractBean.getContractno());
			System.out.println("Delivery Date:"+contractBean.getDate());
			System.out.println("Product ID:"+contractBean.getProdid());
			System.out.println("Quantity:"+contractBean.getQty());
			System.out.println("Day:"+contractBean.getDay());
			System.out.println("HaulierId:"+contractBean.getHaulid());
			System.out.println("Order Status:"+contractBean.getOrderStatus());
			System.out.println("-------------------------------------------------------------");
			b1=false;
			}
			else {
				
				System.out.println("Enter Valid ContractNo");
		}
			}
		
		default:
			break;
		}

		
	
}
}
