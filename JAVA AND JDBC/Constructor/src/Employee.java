
public class Employee {
	String empName;
	int empAge;
	double empSalary;
	
	Employee(String name, int age, double salary){
		empName=name;
		empAge=age;
		empSalary=salary;
	}
	void empDetails() {
		System.out.println("emp name: "+empName+" emp age: "+empAge+" emp salary: "+empSalary);
	}
	

}
