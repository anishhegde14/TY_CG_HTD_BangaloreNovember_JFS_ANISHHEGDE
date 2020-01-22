package com.capgemini.selenium.webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandle {

	static {

		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

	}
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
//		String url=driver.getWindowHandle();
//		Window
//		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.get("https://www.instagram.com");
		Set<String> whs=driver.getWindowHandles();
		System.out.println("No of windows="+whs.size());
		System.out.println(whs);
		//driver.quit();
		
		
		
	}
}
