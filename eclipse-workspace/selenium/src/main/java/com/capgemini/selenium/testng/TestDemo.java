package com.capgemini.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class TestDemo {
static {

		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

	}

	
	@Test
	public void demo1() {
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		Reporter.log("from testDemo demo1",true);
	}
	@Test
	public void demo2() {
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com");
		Reporter.log("from testDemo demo1",true);
	}
}
