package exceptionprogation;

public class C {
	static void m() {
		try {
		System.out.println(10/0);
		}
		catch(ArithmeticException e) {
			System.out.println("c class"+e.getMessage());
			throw e;
		}
	}

}
