package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {

	
	WebDriver driver;
	
	@Given("^User navigate to login page$")
	public void user_navigate_to_login_page() throws Throwable {
		driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
	}
//	@When("^User enters \"(.*)\" and \"(.*)\"$") to check with through feature file.....feATURE file input must beScenario:Successfull login with valid credentials
	/*Given User navigate to login page
	When User enters "admin" and "manager"
	Then Login should be Successfull*/
//	public void user_enters_username_and_password(String un,String pw) throws Throwable {
//		driver.findElement(By.name("username")).sendKeys(un);
//		driver.findElement(By.xpath("//*[@id=\"loginFormContainer\"]/tbody/tr[1]/td/table/tbody/tr[2]/td/input")).sendKeys(pw);
//		driver.findElement(By.id("loginButton")).click();
//	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String un,String pw) throws Throwable {
		
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.xpath("//*[@id=\"loginFormContainer\"]/tbody/tr[1]/td/table/tbody/tr[2]/td/input")).sendKeys(pw);
		driver.findElement(By.id("loginButton")).click();
	}

	@Then("^Login should be Successfull$")
	public void login_should_be_Successfull() throws Throwable {
		Thread.sleep(5000);
		String actualtitle=driver.getTitle();
		Assert.assertEquals(actualtitle, "actiTIME - Enter Time-Track");
		System.out.println("Login Successful!!!!");
	}


}
