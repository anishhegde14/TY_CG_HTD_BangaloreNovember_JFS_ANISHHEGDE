package interfaceConcept;

public class Son implements Father1, Father2 {

	@Override
	public void home() {
		// TODO Auto-generated method stub
		//Father1.super.home();
		Father2.super.home();
	}

}
