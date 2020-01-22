package com.capgemini.selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertProgram {
static {

		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

	}
public static void main(String[] args) throws InterruptedException {

	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	driver.manage().window().maximize();
	driver.get("http://demo.guru99.com/v1/index.php");
	driver.findElement(By.name("btnLogin")).click();
	Thread.sleep(5000);
	Alert alert=driver.switchTo().alert();
	String msg=alert.getText();
	System.out.println(msg);
	alert.accept();
}
}