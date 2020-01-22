package com.capgemini.selenium.assertandsoftassert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {

	
	@Test
	public void test1() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		String actual=driver.getTitle();
		String expected="actiTIME";
		Assert.assertEquals(actual, expected);
		Thread.sleep(10000);
		driver.close();
	}
	@Test
	public void test2() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		String actual=driver.getTitle();
		String expected="actiTIME";
		SoftAssert s=new SoftAssert();
		s.assertEquals(actual, expected);
		Thread.sleep(10000);
		driver.close();
		s.assertAll();
	}

}
