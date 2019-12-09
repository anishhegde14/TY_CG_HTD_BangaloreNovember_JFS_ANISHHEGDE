package throwandthrows;

public class Paytm {
	IRCTC i1;

	public Paytm(IRCTC i1) {
		super();
		this.i1 = i1;
	}
	void bookTicket() {
		try {
			i1.confirmTicket();
		}
		catch(ClassNotFoundException c) {
			System.out.println("ticket not confirmed");
		}
	}

}
