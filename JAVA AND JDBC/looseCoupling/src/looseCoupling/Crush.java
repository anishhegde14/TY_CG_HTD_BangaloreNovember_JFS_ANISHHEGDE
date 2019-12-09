package looseCoupling;

public class Crush {
	void recieve(Phone p) {
		if(p instanceof BasicPhone)
			System.out.println("Thanks");
		else if(p instanceof Oppo)
			System.out.println("Thank you");
		else if(p instanceof OnePlus)
			System.out.println("Thank you so much dear");
		else if(p instanceof Apple)
			System.out.println("love you");
		else
			System.out.println("idiot");
	}
}
