package thread;

public class User extends Thread{
	PVR p;
	User(PVR p){
		this.p=p;
	}
	@Override
	public void run() {
		p.confirmTicket();
	}
	
	

}
