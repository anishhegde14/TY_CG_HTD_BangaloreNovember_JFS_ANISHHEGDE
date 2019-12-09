package interfaceConcept;

public class Pepsi2 implements Bottle {

	@Override
	public void open() {
		System.out.println("open the pepsi bottle");
	}

	@Override
	public void drink() {
		System.out.println("drinking Pepsi");
	}
	//public void juice() {
		//System.out.println("drinking juice");
	//}

}
