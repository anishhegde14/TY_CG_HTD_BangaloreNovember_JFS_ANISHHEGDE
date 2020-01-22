package com.capgemini.selenium.annotationorder;

import org.testng.Reporter;
public class Test extends BaseTest{
	@org.testng.annotations.Test
	public void test1()
	{
		Reporter.log("testB1",true);
		
	}
	@org.testng.annotations.Test
	public void test2()
	{
		Reporter.log("testB2",true);
	}

}
