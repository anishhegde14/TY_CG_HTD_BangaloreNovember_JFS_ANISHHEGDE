package exception;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("main started");
		Calculator c=new Calculator();
		try {
		c.divide(10,0);
		}catch(ArithmeticException a) {
			System.out.println("you cannot divide with 0");
		}
		System.out.println("main ended");
	}

}
