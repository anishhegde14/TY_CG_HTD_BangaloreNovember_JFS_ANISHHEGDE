package throwandthrows;

public class IRCTC {

	void confirmTicket() throws ClassNotFoundException {
		try {
			Class c2=Class.forName("Paytm");
			System.out.println("Ticket is confirmed");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Ticket not confirmed");
			throw e;
		}
	}

}
