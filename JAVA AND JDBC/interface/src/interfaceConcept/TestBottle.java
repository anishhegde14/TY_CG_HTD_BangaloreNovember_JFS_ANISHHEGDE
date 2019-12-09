package interfaceConcept;

public class TestBottle {
	public static void main(String[] args) {
		Pepsi p=new Pepsi();
		Fanta f=new Fanta();
		
		p.open();
		p.drink();
		System.out.println("---------------------");
		f.open();
		f.drink();
	}

}
