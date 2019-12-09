package customexception;

public class ATMSimulator {
	
	void withdraw(double amount) {
		if(amount>40000) {
			throw new DayLimitException("limit exceeded");
		}
	}

}
