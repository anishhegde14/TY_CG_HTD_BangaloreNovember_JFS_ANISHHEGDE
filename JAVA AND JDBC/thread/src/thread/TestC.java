package thread;

public class TestC {
	public static void main(String[] args) {
		System.out.println("main start");
		PVR p=new PVR();
		
		User u=new User(p);
		
		u.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		p.leaveMe();
		System.out.println("main ended");
	}

}
