package Demo;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo {

	@Test
	public void m1() {
		Reporter.log("hello",true);
	}
}
