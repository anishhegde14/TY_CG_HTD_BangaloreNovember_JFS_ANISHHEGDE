package throwandthrows;

public class User {
	public static void main(String[] args) {
		System.out.println("main started");
		IRCTC i1=new IRCTC();
		Paytm p=new Paytm(i1);

		p.bookTicket();
		System.out.println("main ended");
	}

}
