package exception;

public class ExceptionA {
	
	void exception(int a, String b) {
		try {
		System.out.println(500/a);
		System.out.println(b.length());
		}
		catch(ArithmeticException e) {
			System.out.println("dont deal with 0");
		}
		catch(NullPointerException e1) {
			System.out.println("dont deal with null");
		}
	}

}
