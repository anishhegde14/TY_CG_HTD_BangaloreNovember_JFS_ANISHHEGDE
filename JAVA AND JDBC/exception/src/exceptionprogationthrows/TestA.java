package exceptionprogationthrows;

public class TestA {
	public static void main(String[] args) {
		System.out.println("main start");
		try {
			A.o();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Class not found handled in A Class");
		}
		System.out.println("main end");
	}

}
