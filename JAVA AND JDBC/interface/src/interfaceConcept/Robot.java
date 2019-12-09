package interfaceConcept;

public class Robot implements Movement, Sound {

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("robot is speaking");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Robot is moving");
	}

}
