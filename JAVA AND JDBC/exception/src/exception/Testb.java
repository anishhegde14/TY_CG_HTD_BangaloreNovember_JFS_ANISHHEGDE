package exception;

public class Testb {
	void write() {
		String s1=null;

		System.out.println("length of the string is "+s1.length());
	}
	public static void main(String[] args) {
		System.out.println("main started");
		Testb b1=new Testb();
		try {
			b1.write();
		}
		catch(NullPointerException n) {
			System.out.println("don't deal with null");
		}
		System.out.println("main ended");
	}
}
