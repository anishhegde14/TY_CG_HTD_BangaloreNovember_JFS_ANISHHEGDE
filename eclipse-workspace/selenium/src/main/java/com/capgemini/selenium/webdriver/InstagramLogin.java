package com.capgemini.selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstagramLogin {
static {

		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

	}
public static void main(String[] args) throws InterruptedException {

	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	driver.manage().window().maximize();
	driver.get("https://www.instagram.com/accounts/login/?source=auth_switcher");
	driver.findElement(By.name("username")).sendKeys("anishhegde14@gmail.com");
	
	driver.findElement(By.name("password")).sendKeys("@NISH@CR7");
	driver.findElement(By.xpath("//button/div[text()='Log In']")).click();
	

}
}