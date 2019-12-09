package exceptionprogation;

public class B {
	
	static void n() {
		try {
		C.m();
		}
		catch(ArithmeticException e) {
			System.out.println("class B"+ e.getMessage());
			throw e;
		}
	}

}
