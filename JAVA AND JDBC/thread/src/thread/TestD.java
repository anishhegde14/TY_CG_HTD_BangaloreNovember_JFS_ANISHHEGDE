package thread;

public class TestD {
	public static void main(String[] args) {
		System.out.println("main started");
		IRCTC i1=new IRCTC();
		
		User1 u=new User1(i1);
		u.start();
		User1 u2=new User1(i1);
		u2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i1.leaveMe();
		System.out.println("main ended");
	}
}
