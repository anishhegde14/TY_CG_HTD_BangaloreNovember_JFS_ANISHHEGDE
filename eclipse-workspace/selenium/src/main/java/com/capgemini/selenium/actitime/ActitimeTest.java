package com.capgemini.selenium.actitime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ActitimeTest extends BaseTest{



@Test
public void before() throws InterruptedException
{	
	
	driver.findElement(By.name("username")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"loginFormContainer\"]/tbody/tr[1]/td/table/tbody/tr[2]/td/input")).sendKeys("manager");
	driver.findElement(By.id("loginButton")).click();
	Thread.sleep(5000l);
	driver.findElement(By.xpath("//a[text()='Logout']")).click();
	Thread.sleep(5000);

}
	
}