package cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Test11 {
	
static {

		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
	}
	@Test
	public void demo() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
	}
	
}
