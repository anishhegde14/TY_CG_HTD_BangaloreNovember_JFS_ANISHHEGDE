
public class Car extends Vehicle {
	int cost=30000;
	void carDetails() {
		int cost=10000;
		System.out.println(cost);
		System.out.println(this.cost);
		System.out.println(super.cost);
	}
}
