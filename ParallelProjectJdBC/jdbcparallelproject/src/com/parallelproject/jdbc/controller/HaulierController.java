package com.parallelproject.jdbc.controller;

import java.util.List;
import java.util.Scanner;

import com.parallelproject.jdbc.forestrybean.ContractBean;
import com.parallelproject.jdbc.forestryservices.ContractServices;
import com.parallelproject.jdbc.forestryservices.ContractServicesImpl;
import com.parallelproject.jdbc.forestryservices.ProductServices;
import com.parallelproject.jdbc.forestryservices.ProductServicesImpl;

public class HaulierController {
	Scanner sc = new Scanner(System.in);
	ProductServices productServices=new ProductServicesImpl();
	ContractServices contractServices=new ContractServicesImpl();
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
	public void haulierController(int id)
	{
		
		System.out.println("Hi Haulier!!!!Hope You Are Having A Great Day");
		if(contractServices.getAllContractOfHaulier(id)!=null) {
		System.out.println("The Order That Needs To Be Delivered Soon Are:");
		List<ContractBean> list=contractServices.getAllContractOfHaulier(id);
		while(true) {
		for (ContractBean contractBean : list) {
			System.out.println("ContractNo="+contractBean.getContractno());
			System.out.println("CustomerId"+contractBean.getCustomerid());
			System.out.println("Order Status="+contractBean.getOrderStatus());
			System.out.println("Product Name"+productServices.findProduct((int)contractBean.getProdid()));
			System.out.println(contractBean.getDate());
		}
		System.out.println("If You Have Delivered Any Orders Then Please Change The Status");
		System.out.println("Press 1 To Change The Status Of Any Order");
		System.out.println("Press 2 To Find A Order");
		System.out.println("Press 3 To See All Orders");
		System.out.println("Press 4 to return");
		
		int choice=0;
		boolean isValid1=true;
		while(isValid1) {
			int choice2=(int) isNoValid();
			if(choice2>=1 && choice2<=5) {
			choice=choice2;
			isValid1=false;}

		}
		switch (choice) {
		case 1:List<ContractBean> beanlist=contractServices.getAllContractOfHaulier(id);
		for (ContractBean contractBean2 : beanlist) {
			if(!contractBean2.getOrderStatus().equals("Delivered")) {
				System.out.print("ContractId:"+contractBean2.getContractno());
				System.out.println("Delivery Date:"+contractBean2.getDate());
				System.out.println("Product ID:"+contractBean2.getProdid());
				System.out.println("Quantity:"+contractBean2.getQty());
				System.out.println("Day:"+contractBean2.getDay());
				System.out.println("HaulierId:"+contractBean2.getHaulid());
				System.out.println("order Status="+contractBean2.getOrderStatus());
				System.out.println("-----------------------------------------------------");
			}
		}
		int schoice=0;
		boolean isValid2=true;
		while(isValid2) {
		try {
			System.out.println("Enter ContractID");
		Scanner sc=new Scanner(System.in);
			int choice2=sc.nextInt();
			if(contractServices.findContract(choice2).getHaulid() == id)
			{
			schoice=choice2;
			isValid2=false;}
		} catch (Exception e) {
			System.out.println("Invalid Input!!!!");
		}}
		if(contractServices.findContract(schoice).getOrderStatus().equals("Ordered")) {
			
			System.out.println("Press 1 To Change It to Delivered");
			
			int dchoice=0;
			boolean isValid3=true;
			while(isValid3) {
			try {
			Scanner sc=new Scanner(System.in);
				int choice2=sc.nextInt();
				if(choice2==1)
				{
				dchoice=choice2;
				isValid3=false;}
				else {
					System.out.println("Enter Valid Input");
				}
			} catch (Exception e) {
				System.out.println("Invalid Input!!!!");
			}}
			
			
			boolean isUpdated=contractServices.updateContractid(schoice);
			if(isUpdated) {
				System.out.println("Order Status Updated");
				System.out.println("Congrats You Have Successfully Delivered");
			}
			else {
				System.out.println("NOT UPDATED!!!");
			}
			
		}
		else
		{
			System.out.println("The Product Is Already Delivered");
		}
		
			
			break;
		case 2:System.out.println("Enter The Order You Want To Find");
		long contractId=0;
		boolean isValid3=true;
		while(isValid3) {
			try {
			Scanner sc=new Scanner(System.in);
				int choice2=(int) isNoValid();
				if(contractServices.findContract(choice2).getHaulid() == id)
				{
				contractId=choice2;
				isValid3=false;}
				else {
					System.out.println("Enter Valid ContractId");
				}
			} catch (Exception e) {
				System.out.println("Invalid Input!!!!");
			}}
		ContractBean contractBean=contractServices.findContract((int)contractId);
		System.out.print("ContractId:"+contractBean.getContractno());
		System.out.println("Delivery Date:"+contractBean.getDate());
		System.out.println("Product ID:"+contractBean.getProdid());
		System.out.println("Quantity:"+contractBean.getQty());
		System.out.println("Day:"+contractBean.getDay());
		System.out.println("HaulierID:"+contractBean.getHaulid());
		System.out.println("Order Status:"+contractBean.getOrderStatus());		
		break;
		case 3:List<ContractBean> contractList=contractServices.getAllContractOfHaulier(id);
		for (ContractBean contractBean1 : contractList) {
			System.out.print("ContractId:"+contractBean1.getContractno());
			System.out.println("Delivery Date:"+contractBean1.getDate());
			System.out.println("Product ID:"+contractBean1.getProdid());
			System.out.println("Quantity:"+contractBean1.getQty());
			System.out.println("Day:"+contractBean1.getDay());
			System.out.println("HaulierID:"+contractBean1.getHaulid());
			System.out.println("Order Status:"+contractBean1.getOrderStatus());
			System.out.println("-------------------------------------------------------------");
		}
		case 4:return;
		default:
			break;
		}
		
		
		}
		}
		else {
			
			
			System.out.println("Sorry!!!No Orders Left For you");
			System.out.println("Press 1 to Logout");
				
			int choice1=0;
			boolean isValid=true;
			while(isValid) {
			try {
			Scanner sc=new Scanner(System.in);
				int choice2=(int) isNoValid();
				isValid=false;
			} catch (Exception e) {
				System.out.println("Invalid Input!!!");
				
			}
			if(choice1==1) {
				return;
			}
			else {
				System.out.println("Enter Correct Choice");
			}
			
			
			}
			List<ContractBean> bean=contractServices.getAllContractOfHaulier(id);
					for (ContractBean contractBean2 : bean) {
						
					System.out.print("ContractId:"+contractBean2.getContractno());
					System.out.println("Delivery Date:"+contractBean2.getDate());
					System.out.println("Product ID:"+contractBean2.getProdid());
					System.out.println("Quantity:"+contractBean2.getQty());
					System.out.println("Day:"+contractBean2.getDay());
					System.out.println("HaulierId:"+contractBean2.getHaulid());
					System.out.println("order Status="+contractBean2.getOrderStatus());
					System.out.println("-----------------------------------------------------");
					}
				}

	
	
	
		
	}
		
		
		
		
	}
	
	

