package exception;

public class ExTest {
	public static void main(String[] args) {
		System.out.println("main started");
		ExceptionB a=new ExceptionB();
		a.exception(0, "mb");
		a.exception(2, null);
		System.out.println("main ended");
	}

}