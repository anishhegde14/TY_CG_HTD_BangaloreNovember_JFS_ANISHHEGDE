
public class Employee2 implements Comparable<Employee2> {
	
	int age;
	int salary;
	String name;
	public Employee2(int age, int salary, String name) {
		super();
		this.age = age;
		this.salary = salary;
		this.name = name;
	}
	@Override
	public int compareTo(Employee2 o) {
		return this.name.compareTo(o.name);
	}
	
	

}