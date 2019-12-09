package finallyblock;

public class Test {

	public static void main(String[] args) {
		System.out.println("main start");
		try {
			System.out.println(10/0);
		}
		catch(ArithmeticException e) {
			System.out.println("dont deal with 0");
		}
		finally {
			System.out.println("finally block is called");
		}
		System.out.println("Main has ended");
	}

}
