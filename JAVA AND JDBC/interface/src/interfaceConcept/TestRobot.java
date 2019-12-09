package interfaceConcept;

public class TestRobot {
	public static void main(String[] args) {
		Robot r=new Robot();
		r.move();
		r.speak();
		Movement m=new Robot();//up-casting
		System.out.println("---------------------");
		m.move();
	}

}
