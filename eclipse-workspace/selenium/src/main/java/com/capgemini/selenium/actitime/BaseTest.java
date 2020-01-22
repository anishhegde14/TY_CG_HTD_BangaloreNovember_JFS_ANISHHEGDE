package com.capgemini.selenium.actitime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
static {

		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
	}
public static WebDriver driver;
@BeforeTest
public  void beforeTest() {
	
	  driver=new ChromeDriver();
	  driver.get("https://demo.actitime.com/login.do");
}

@AfterTest
public void afterTest()
{
	driver.close();
}
}
