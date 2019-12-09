package interfaceConcept;

public class Pepsi implements Bottle {

	@Override
	public void open() {
		System.out.println("opening pepsi");
	}

	@Override
	public void drink() {
		System.out.println("drinking pepsi");
	}

}
