package exception;

public class TestA {
	public static void main(String[] args) {
		System.out.println("main started");
		ExceptionA a=new ExceptionA();
		a.exception(0, "mb");
		a.exception(2, null);
		System.out.println("main ended");
	}

}
