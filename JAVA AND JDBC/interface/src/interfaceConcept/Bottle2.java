package interfaceConcept;

public interface Bottle2 {
	void open();
	void drink();
	
	default void juice(){
		System.out.println("Juice bottle");
	}
	
	static void close() {
		System.out.println("Closing bottle");
	}

}
