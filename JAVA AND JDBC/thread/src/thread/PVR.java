package thread;

public class PVR {

	synchronized void confirmTicket() {
		for(int i=0;i<4;i++){
			System.out.println(i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				System.out.println(e.getMessage());
//			}
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	synchronized void leaveMe() {
		System.out.println("notify called");
		notify();
	}

}
