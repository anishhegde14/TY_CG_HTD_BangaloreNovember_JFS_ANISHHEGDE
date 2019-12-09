
public class Vehicle implements Cloneable{
	String carName;

	public Vehicle(String carName) {
		super();
		this.carName = carName;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
		
}
