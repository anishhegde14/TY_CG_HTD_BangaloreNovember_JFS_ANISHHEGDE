
public class TestVehicle {
	public static void main(String[] args) throws CloneNotSupportedException {
		Vehicle v=new Vehicle("benz");
		Object o=v.clone();
		Vehicle v1=(Vehicle)o;
		System.out.println(v1.carName);
	}
}
