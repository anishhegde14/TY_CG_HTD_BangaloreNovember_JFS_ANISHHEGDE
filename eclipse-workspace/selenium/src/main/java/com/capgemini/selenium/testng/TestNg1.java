package com.capgemini.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNg1 {
static {

		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

	}

	
	@Test
	public void demo1() {
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		Reporter.log("from testNg1",true);
	}
}
