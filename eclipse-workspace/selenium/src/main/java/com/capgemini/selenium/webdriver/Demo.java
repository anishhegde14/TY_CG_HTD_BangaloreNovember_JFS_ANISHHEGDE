package com.capgemini.selenium.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
static {
	
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
}
	

public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.seleniumhq.org/");
	driver.manage().window().maximize();
	driver.navigate().to("https://www.google.com/");
	System.out.println(driver.getCurrentUrl());
	
	driver.navigate().back();
	String title=driver.getTitle();
	System.out.println(title);
	driver.close();
}
}
