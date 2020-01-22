package com.parallelproject.hibernate.controller;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.parallelproject.hibernate.forestrybean.CustomerBean;
import com.parallelproject.hibernate.forestrybean.HaulierBean;
import com.parallelproject.hibernate.forestrybean.ProductBean;
import com.parallelproject.hibernate.forestryservices.CustomerServices;
import com.parallelproject.hibernate.forestryservices.CustomerServicesImpl;
import com.parallelproject.hibernate.forestryservices.HaulierServices;
import com.parallelproject.hibernate.forestryservices.HaulierServicesImpl;
import com.parallelproject.hibernate.forestryservices.ProductServices;
import com.parallelproject.hibernate.forestryservices.ProductServicesImpl;
import com.parallelproject.hibernate.login.LoginVerify;

public class AdminController {
	ProductServices productServices = new ProductServicesImpl();
	HaulierServices haulierServices = new HaulierServicesImpl();
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
	// Email Regex java
	private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

	// static Pattern object, since pattern is fixed
	private static Pattern pattern;

	// non-static Matcher object because it's created from the input String
	private Matcher matcher;

	public AdminController() {
		// initialize the Pattern object
		pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
	}

	/**
	 * This method validates the input email address with EMAIL_REGEX pattern
	 * 
	 * @param email
	 * @return boolean
	 */
	public boolean validateEmail(String email) {
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	Scanner sc = new Scanner(System.in);
	CustomerServices customerservices = new CustomerServicesImpl();
	HaulierServices haulierservices = new HaulierServicesImpl();
	LoginVerify loginverify = new LoginVerify();

	public int isValidCustomerId() {
		System.out.println("Enter ID");
		boolean a = true;
		int id = 0;
		while (a) {

			int idValid = sc.nextInt();
			if (loginverify.validId(idValid) != 0) {
				System.out.println("Enter Valid Id");
			} else {
				id = idValid;
				a = false;

			}
		}
		return id;
	}public int isValidHaulierId() {
		System.out.println("Enter Haulier ID");
		boolean a = true;
		int id = 0;
		while (a) {

			int idValid =(int) isNoValid();
			if (haulierservices.findHaulier(idValid)!=null) {
				id = idValid;
				a = false;
			} else {
				System.out.println("Enter Valid Id");

			}
		}
		return id;
	}

	public String isValidCustomerName() {
		System.out.println("Enter Name");
		boolean a = true;
		String nameValid = null;
		while (a) {

			String nameValid1 = sc.next();
			if (nameValid1.equalsIgnoreCase(loginverify.validName(nameValid1))) {
				System.out.println("Enter Valid Id");
			} else {
				a = false;
				nameValid = nameValid1;

			}
		}
		return nameValid;
	}

	public void admincontrol(int id) {

		System.out.println("Welcome Oh Great One");
		System.out.println("Please Tell What You want To Do With This World");
		System.out.println("Press 1 To Play With  Customer DB");
		System.out.println("Press 2 To Play With  Haulier DB");
		System.out.println("Press 3 To Play With  Product DB");
		System.out.println("Press 4 To Play With  Orders");
		int choice = (int) isNoValid();
		switch (choice) {
		case 1:boolean customerChoice=true;
			while(customerChoice) {
			System.out.println("Press 1 to Add a Customer");
			System.out.println("Press 2 to Update a Customer");
			System.out.println("Press 3 to Delete a Customer");
			System.out.println("Press 4 to See all Customer");
			System.out.println("Press 5 to Go Back");
			int choice1 = (int) isNoValid();
			switch (choice1) {
			case 1:
				System.out.println("Enter Customer Id");
				long custId = isValidCustomerId();
				System.out.println("Enter Customer name");
				String custName = isValidCustomerName();
				System.out.println("Enter Street Address 1");
				String add1 = sc.next();
				System.out.println("Enter Street Address 2");
				String add2 = sc.next();
				System.out.println("Enter Town");
				String town = sc.next();
				System.out.println("Enter Postal Code");
				boolean post = true;
				long postalCode1 = 0;
				while (post) {

					long postalCode;
					try {
						postalCode = isNoValid();
						if (postalCode > 500000 && postalCode < 600000) {
							post = false;

						} else {
							System.out.println("Enter Valid Postal Code");
						}
					} catch (Exception e) {
						System.out.println("Enter Valid Code");
					}
				}
				System.out.println("Enter Email ID");
				boolean isemail = true;
				String email = null;
				while (isemail) {
					String email1 = sc.next();
					if (validateEmail(email1)) {
						isemail = false;
						email = email1;
					} else {
						System.out.println("Enter Valid EmailId");
					}
				}
				System.out.println("Enter Phone no");
				long mob_no = 0;
				boolean isPhone = true;
				while (isPhone) {

					long mob_no1=0;
					try {
						mob_no1 = isNoValid();
						if (mob_no1 > 1000000000l && mob_no1 < 9999999999l) {
							isPhone = false;
							mob_no = mob_no1;

						} else {
							System.out.println("Enter Valid Phone no");
						}
					} catch (Exception e) {
						System.out.println("Enter Valid Phone no");
						Scanner sc = new Scanner(System.in);
					}
				}
				CustomerBean customer = new CustomerBean();
				customer.setCustomerid(custId);
				customer.setCustomername(custName);
				customer.setAddress1(add1);
				customer.setAddress2(add2);
				customer.setEmail(email);
				customer.setNo(mob_no);
				customer.setPostalcode(postalCode1);
				customer.setTown(town);
				if (customerservices.addCustomer(customer)) {
					System.out.println("Customer Added Successfully");
					if (loginverify.addLoginCredentials((int) custId, custName, 1)) {
						System.out.println("Login Credentials Generated");
						System.out.println("ID:" + custId + "name:" + custName);
					}else {
						customerservices.deleteCustomer((int)custId);
					}

				} else {

					System.out.println("Customer not added");
				}

				break;
			case 2:System.out.println("enter The CustomerId you want to update");
			boolean isExist=true;
			while(isExist) {
			long custId1 = isValidCustomerId();
			if(customerservices.findCustomer((int) custId1)!=null) {
			System.out.println("Enter Customer name");
			String custName1 = isValidCustomerName();
			System.out.println("Enter Street Address 1");
			String add11 = sc.next();
			System.out.println("Enter Street Address 2");
			String add21 = sc.next();
			System.out.println("Enter Town");
			String town1 = sc.next();
			System.out.println("Enter Postal Code");
			boolean post1 = true;
			long postalCode11 = 0;
			while (post1) {
				
				long postalCode;
				try {
					postalCode = isNoValid();
					if (postalCode > 500000 && postalCode < 600000) {
						post1 = false;
						postalCode11=postalCode;
					} else {
						System.out.println("Enter Valid Postal Code");
					}
				} catch (Exception e) {
					System.out.println("Enter Valid Code");
				}
			}
			System.out.println("Enter Email ID");
			boolean isemail1 = true;
			String email2 = null;
			while (isemail1) {
				String email1 = sc.next();
				if (validateEmail(email1)) {
					isemail1 = false;
					email2 = email1;
				} else {
					System.out.println("Enter Valid EmailId");
				}
			}
			System.out.println("Enter Phone no");
			long mob_no1 = 0;
			boolean isPhone1 = true;
			while (isPhone1) {

				long mob_no11=0;
				try {
					mob_no11 = isNoValid();
					if (mob_no11 > 1000000000l && mob_no11 < 9999999999l) {
						isPhone1 = false;
						mob_no1 = mob_no11;

					} else {
						System.out.println("Enter Valid Phone no");
					}
				} catch (Exception e) {
					System.out.println("Enter Valid Phone no");
					Scanner sc = new Scanner(System.in);
				}
			}
			CustomerBean customer1 = new CustomerBean();
			customer1.setCustomerid(custId1);
			customer1.setCustomername(custName1);
			customer1.setAddress1(add11);
			customer1.setAddress2(add21);
			customer1.setEmail(email2);
			customer1.setNo(mob_no1);
			customer1.setPostalcode(postalCode11);
			customer1.setTown(town1);
			if (customerservices.updateCustomer(customer1)) {
				System.out.println("Customer Updated Successfully");
				}

			 else {

				System.out.println("Customer not updated");
			}}
			else {
				System.out.println("Enter Valid Id");
			}
			}
		
				
				break;
			case 3:
				System.out.println("Enter The customer you want to Delete");
				System.out.println("Your options are");
				List<CustomerBean> customerBeanList = customerservices.getAllCustomer();
				for (CustomerBean customerBean : customerBeanList) {
					System.out.println("Customer Name:" + customerBean.getCustomername());
					System.out.println("Customer Id:" + customerBean.getCustomerid());
					System.out.println("----------------------------------------------------------------");
				}
				System.out.println("Enter The Id You Want to Delete");
				boolean b = true;
				while (b) {
					try {
						int customerId = (int)isNoValid();
						if (customerservices.findCustomer(customerId) != null) {
							if (customerservices.deleteCustomer(customerId)) {
								System.out.println("Customer Deleted SuccessFully");
								b = false;
								if (loginverify.deleteContract(customerId)) {
									System.out.println("Login Credentials Deleted SuccessFully");
								}
							}
						} else {

							System.out.println("Enter Valid Credentials");

						}
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Not Valid Entry");
					}
				}
				break;
			case 4:
				List<CustomerBean> customerBeanList1 = customerservices.getAllCustomer();
				for (CustomerBean customerBean : customerBeanList1) {
					System.out.println("Customer Name:" + customerBean.getCustomername());
					System.out.println("Customer Id:" + customerBean.getCustomerid());
					System.out.println("Customer StreetAddress1:" + customerBean.getAddress1());
					System.out.println("Customer StreetAddress2:" + customerBean.getAddress2());
					System.out.println("Customer emailId:" + customerBean.getEmail());
					System.out.println("Customer Phone:" + customerBean.getNo());
					System.out.println("Customer Town:" + customerBean.getTown());
					System.out.println("Customer Pin Code:" + customerBean.getPostalcode());
					System.out.println("----------------------------------------------------------------");
				}
				break;
			case 5:customerChoice=false;
			default:
				break;
			}
			}
		case 2:boolean haulChoice=true;
		while(haulChoice) {
			System.out.println("Press 1 to Add a Haulier");
			System.out.println("Press 2 to Update a Haulier");
			System.out.println("Press 3 to Delete a Haulier");
			System.out.println("Press 4 to Find a haulier");
			System.out.println("Press 5 to See all Haulier");
			int choice2 = (int)isNoValid();
			switch (choice2) {
			case 1:
				System.out.println("Enter Haulier Id");
				long haulId = isValidCustomerId();
				System.out.println("Enter Haulier name");
				String haulName = isValidCustomerName();
				System.out.println("Enter Street Address 1");
				String add1 = sc.next();
				System.out.println("Enter Street Address 2");
				String add2 = sc.next();
				System.out.println("Enter Town");
				String town = sc.next();
				System.out.println("Enter Postal Code");
				boolean post = true;
				long postalCode1 = 0;
				while (post) {

					long postalCode;
					try {
						postalCode = (int)isNoValid();
						if (postalCode > 500000 && postalCode < 600000) {
							post = false;

						} else {
							System.out.println("Enter Valid Postal Code");
						}
					} catch (Exception e) {
						System.out.println("Enter Valid Code");
					}
				}
				System.out.println("Enter Email ID");
				boolean isemail = true;
				String email = null;
				while (isemail) {
					String email1 = sc.next();
					if (validateEmail(email1)) {
						isemail = false;
						email = email1;
					} else {
						System.out.println("Enter Valid EmailId");
					}
				}
				System.out.println("Enter Phone no");
				long mob_no = 0;
				boolean isPhone = true;
				while (isPhone) {

					long mob_no1;
					try {
						mob_no1 = isNoValid();
						if (mob_no1 > 1000000000l && mob_no1 < 9999999999l) {
							isPhone = false;
							mob_no = mob_no1;

						} else {
							System.out.println("Enter Valid Phone no");
						}
					} catch (Exception e) {
						System.out.println("Enter Valid Phone no");
					}
				}
				HaulierBean haulier = new HaulierBean();
				haulier.setHaulierid(haulId);
				haulier.setHauliername(haulName);
				haulier.setAddress1(add1);
				haulier.setAddress2(add2);
				haulier.setEmail(email);
				haulier.setNo(mob_no);
				haulier.setPostalcode(postalCode1);
				haulier.setTown(town);
				if (haulierservices.addHaulier(haulier)) {
					System.out.println("Haulier Added Successfully");
					if (loginverify.addLoginCredentials((int) haulId, (String) haulName, 2)) {
						System.out.println("Login Credentials Generated");
						System.out.println("ID:" + haulId + "name:" + haulName);
					}

				} else {

					System.out.println("Haulier not added");
				}

				break;
			case 2:
				System.out.println("Enter Haulier Id");
				long haulId1 = isValidHaulierId();
				System.out.println("Enter Haulier name");
				String haulName1 = isValidCustomerName();
				System.out.println("Enter Street Address 1");
				String add11 = sc.next();
				System.out.println("Enter Street Address 2");
				String add21 = sc.next();
				System.out.println("Enter Town");
				String town1 = sc.next();
				System.out.println("Enter Postal Code");
				boolean post1 = true;
				long postalCode11 = 0;
				while (post1) {

					long postalCode;
					try {
						postalCode = isNoValid();
						if (postalCode > 500000 && postalCode < 600000) {
							post1 = false;
							postalCode11=postalCode;

						} else {
							System.out.println("Enter Valid Postal Code");
						}
					} catch (Exception e) {
						System.out.println("Enter Valid Code");
					}
				}
				System.out.println("Enter Email ID");
				boolean isemail1 = true;
				String email1 = null;
				while (isemail1) {
					String email11 = sc.next();
					if (validateEmail(email11)) {
						isemail1 = false;
						email1 = email11;
					} else {
						System.out.println("Enter Valid EmailId");
					}
				}
				System.out.println("Enter Phone no");
				long mob_no2 = 0;
				boolean isPhone1 = true;
				while (isPhone1) {

					long mob_no1;
					try {
						mob_no1 = isNoValid();
						if (mob_no1 > 1000000000l && mob_no1 < 9999999999l) {
							isPhone1 = false;
							mob_no2 = mob_no1;

						} else {
							System.out.println("Enter Valid Phone no");
						}
					} catch (Exception e) {
						System.out.println("Enter Valid Phone no");
					}
				}
				HaulierBean haulier1 = new HaulierBean();
				haulier1.setHaulierid(haulId1);
				haulier1.setHauliername(haulName1);
				haulier1.setAddress1(add11);
				haulier1.setAddress2(add21);
				haulier1.setEmail(email1);
				haulier1.setNo(mob_no2);
				haulier1.setPostalcode(postalCode11);
				haulier1.setTown(town1);
				if (haulierservices.updateHaulier(haulier1)) {
					System.out.println("Haulier Updated Successfully");
					}

				 else {

					System.out.println("Haulier not Updated");
				}

				break;

			case 3:
				System.out.println("Enter The haulier you want to Delete");
				System.out.println("Your options are");
				List<HaulierBean> haulierBeanList = haulierservices.getAllHaulier();
				for (HaulierBean haulierBean : haulierBeanList) {
					System.out.println("Haulier Name:" + haulierBean.getHauliername());
					System.out.println("Haulier Id:" + haulierBean.getHaulierid());
					System.out.println("----------------------------------------------------------------");
				}
				System.out.println("Enter The Id You Want to Delete");
				boolean b = true;
				while (b) {
					try {
						int haulierId = (int)isNoValid();
						if (haulierservices.findHaulier(haulierId) != null) {
							System.out.println("Entered");
							if (haulierservices.deleteHaulier(haulierId)) {
								System.out.println("Customer Deleted SuccessFully");
								b = false;
								if (loginverify.deleteContract(haulierId)) {
									System.out.println("Login Credentials Deleted SuccessFully");
								}
							}
						} else {

							System.out.println("Enter Valid Credentials");

						}
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Not Valid Entry");
					}
				}
				break;
			case 4:
				
				System.out.println("Enter Haulier Id You Want to Find");
				Integer haulid;
				boolean isHaul=true;
				while (isHaul) {
				try {
					Scanner sc=new Scanner(System.in);
					String id1=sc.next();
					haulid = Integer.parseInt(id1);
				
					if( haulierservices.findHaulier(haulid)!=null) {
				HaulierBean haulierBeanf=haulierservices.findHaulier(haulid);
				System.out.println("Haulier Name:" + haulierBeanf.getHauliername());
				System.out.println("Haulier Id:" + haulierBeanf.getHaulierid());
				System.out.println("Haulier StreetAddress1:" + haulierBeanf.getAddress1());
				System.out.println("Customer StreetAddress2:" + haulierBeanf.getAddress2());
				System.out.println("Haulier emailId:" + haulierBeanf.getEmail());
				System.out.println("Haulier Phone:" + haulierBeanf.getNo());
				System.out.println("Haulier Town:" + haulierBeanf.getTown());
				System.out.println("Haulier Pin Code:" + haulierBeanf.getPostalcode());
				isHaul=false;
					}else {
					System.out.println("Entered haulier not found");
					isHaul=false;
					} 
					}
					
					catch (NumberFormatException e1) {
						System.out.println("Enter Valid ID");
					}}
			
				break;
			case 5:
				List<HaulierBean> haulierBeanList1 = haulierservices.getAllHaulier();
				for (HaulierBean haulierBean : haulierBeanList1) {

					System.out.println("Haulier Name:" + haulierBean.getHauliername());
					System.out.println("Haulier Id:" + haulierBean.getHaulierid());
					System.out.println("Haulier StreetAddress1:" + haulierBean.getAddress1());
					System.out.println("Customer StreetAddress2:" + haulierBean.getAddress2());
					System.out.println("Haulier emailId:" + haulierBean.getEmail());
					System.out.println("Haulier Phone:" + haulierBean.getNo());
					System.out.println("Haulier Town:" + haulierBean.getTown());
					System.out.println("Haulier Pin Code:" + haulierBean.getPostalcode());
					System.out.println("----------------------------------------------------------------");
				}
				break;
			case 6: haulChoice=false;

			default:
				break;
			}}
		case 3:boolean prodChoice=true;
		while(prodChoice) {
			System.out.println("Press 1 to Add a Product");
			System.out.println("Press 2 to Update a Product");
			System.out.println("Press 3 to Delete a Product");
			System.out.println("Press 4 to See all Product");
			int choice3 = (int)isNoValid();
			switch (choice3) {
			case 1:
				System.out.println("Enter Product Name");
				boolean prodname=true;
				String pname="";
				while(prodname)
				{
					String pname1 = sc.next();
					if(productServices.findProduct1(pname1).getProductName()==null)
					{
						prodname=false;
						pname=pname1;
					}
					else
					{
						System.out.println("Entered Product Already Exists Please RE-ENTER NAME");
					}
				}
				System.out.println("Enter Product Id");
				boolean b = true;
				int pid = 0;
				while (b) {
					try {
						boolean c = true;
						while (c) {
						int pid1 = (int)isNoValid();
						b = false;
						System.out.println(productServices.findProduct(pid1));
							if(productServices.findProduct(pid1).getProductId() == 0) {
								pid = pid1;
								c=false;
							}
							else
							{
								System.out.println("Entered ProductId Already Exists!!!");
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Enter Valid Id");
					}
					ProductBean productBean = new ProductBean();
					productBean.setProductId(pid);
					productBean.setProductName(pname);
					if (productServices.addProducts(productBean)) {
						System.out.println("Product Added");
					} else {
						
						System.out.println("Product Not Added");
					}
				}
				break;
			case 2:System.out.println("Enter The Product You Want to Update");
			System.out.println("Enter Product Name");
			ProductBean bean=new ProductBean();
			boolean prodname1=true;
			while(prodname1)
			{
				try {
					String pname1 = sc.next();
					if(productServices.findProduct1(pname1).getProductName()!=null)
					{
						prodname1=false;
						bean.setProductName(pname1);
					bean.setProductId(productServices.findProduct1(pname1).getProductId());
					}
					else
					{
						System.out.println("Entered Product Does Not Exists Please RE-ENTER NAME");
					}
				} catch (Exception e) {
					System.out.println("Enter Valid Product name");
				}
			}
			
			if(productServices.updateProduct(bean, bean.getProductId())) {
				System.out.println("Product Updated Successfully!!! ");
			}
			else
			{
				System.out.println("Product Not Updated!!!");
			}
			
			break;
			case 3:System.out.println("Enter Id You want to delete");
					System.out.println("Your Options Are");
					CustomerController control=new CustomerController();
					boolean isProd=true;
					while(isProd) {
					int deleteProductId=control.isProdValid();
					if(deleteProductId!=0)
					{
						if(productServices.deleteProducts(deleteProductId))
						{
								System.out.println("Product Deleted");
								isProd=false;
						}
						else
						{
							System.out.println("Enter Valid Product");
						}
						
					}
					}
					
			case 4:	List<ProductBean> product = productServices.getAllProducts();
			for (ProductBean productBean : product) {
				System.out.print(productBean.getProductId() + ":");
				System.out.println(productBean.getProductName());
			}
					break;
			case 5:prodChoice=false;
						

			default:
				break;}
			}
		case 5:return;
		
		default:
			break;

		}
	}
}
