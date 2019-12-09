
public class TestEmployee {
	public static void main(String[] args) {
		Employee e=new Employee(22,"divya");
		System.out.println(e.hashCode());
		Employee e2=new Employee(23,"shree");
		System.out.println(e2.hashCode());
		System.out.println(e2);
		Object o=new Object();
	}
}
