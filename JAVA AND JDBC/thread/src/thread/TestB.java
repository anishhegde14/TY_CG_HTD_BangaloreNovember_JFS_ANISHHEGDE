
package thread;

public class TestB {
	public static void main(String[] args) {
		System.out.println("main started");
		Thread2 t=new Thread2();
		Thread t2=new Thread(t);
		
		
		t2.start();
		
		System.out.println("main ended");
	}

}
