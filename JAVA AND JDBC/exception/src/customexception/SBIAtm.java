package customexception;

public class SBIAtm {
	public static void main(String[] args) {
		System.out.println("main started");
		
		ATMSimulator a=new ATMSimulator();
		try {
		a.withdraw(41000);
		}
		catch(DayLimitException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("min ended");
	}

}
