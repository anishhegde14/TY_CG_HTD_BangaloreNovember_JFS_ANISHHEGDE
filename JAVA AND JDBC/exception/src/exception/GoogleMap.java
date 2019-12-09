package exception;

public class GoogleMap {
	
	void findLocation(String str) {
		try {
		System.out.println(str.length());
		}
		catch(NullPointerException e) {
			System.out.println("Google map user fill the location");
			throw e;
		}
		
	}

}
