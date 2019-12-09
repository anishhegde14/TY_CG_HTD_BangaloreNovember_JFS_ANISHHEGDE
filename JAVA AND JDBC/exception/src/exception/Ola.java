package exception;

public class Ola {
	GoogleMap map;

	public Ola(GoogleMap map) {
		super();
		this.map = map;
	}
	void find(String str) {
		try {
		map.findLocation(str);
		}
		catch(NullPointerException e) {
			System.out.println("ola user fill the location");
		}
		
	}
	

}
