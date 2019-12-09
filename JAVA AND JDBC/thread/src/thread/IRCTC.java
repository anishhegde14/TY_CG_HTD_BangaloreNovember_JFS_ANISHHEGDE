package thread;

public class IRCTC {
	
	synchronized void confirmTicket() {
		for(int i=0; i<5; i++) {
			System.out.println(i);
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
	synchronized void leaveMe() {
		System.out.println("notify called");
		//notify(); it leaves only one thread
		notifyAll();//it leaves all the threads
	}

}
