package exception;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("main started");
		GoogleMap m=new GoogleMap();
		Ola o=new Ola(m);
		o.find(null);
		System.out.println("main ended");
	}

}
