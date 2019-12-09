
public class Employee1 implements Comparable<Employee2> {
	
	int age;
	int salary;
	String name;
	public Employee1(int age, int salary, String name) {
		super();
		this.age = age;
		this.salary = salary;
		this.name = name;
	}
	@Override
	public int compareTo(Employee2 o) {
		if(this.salary>o.salary)
		return 1;
		else if(this.salary<o.salary)
			return -1;
		else
			return 0;
	}
	
	

}
