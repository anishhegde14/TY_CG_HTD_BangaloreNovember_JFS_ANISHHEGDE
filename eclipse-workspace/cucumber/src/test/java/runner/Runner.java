package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
//
@CucumberOptions(features = "./src/test/java/Feature")
public class Runner extends AbstractTestNGCucumberTests{
static {

		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
	}
}
//, glue = {"stepdefinition/StepBlue"},
//plugin = {"pretty","html:target/cucumber"},monochrome = true, tags= {"@Smoke"}