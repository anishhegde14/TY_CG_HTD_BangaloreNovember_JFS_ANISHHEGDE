package exception;

public class ExceptionB {

	void exception(int a, String b) {
		try {
			System.out.println(500/a);
			try {
				System.out.println(b.length());
			}
			catch(NullPointerException e1) {
				System.out.println("dont deal with null");

			}
		}

		catch(ArithmeticException e) {
			System.out.println("dont deal with 0");
		}

	}
}