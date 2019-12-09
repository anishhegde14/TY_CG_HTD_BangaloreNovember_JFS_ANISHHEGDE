import java.util.TreeSet;

public class TestSet4 {
	public static void main(String[] args) {

		EmployeeName em1=new EmployeeName();
		EmployeeAge em2=new EmployeeAge();
		EmployeeSalary em3=new EmployeeSalary();

		TreeSet<Employee2> t=new TreeSet<Employee2>(em1);

		t.add(new Employee2(22,3400,"john"));
		t.add(new Employee2(25,2400,"mikel"));
		t.add(new Employee2(21,5400,"mery"));

		for (Employee2 e : t) {
			System.out.println("employee name is "+e.name);
			System.out.println("employee salary is "+e.salary);
			System.out.println("employee age is "+e.age);
			System.out.println("-------------------------");

		}
	}

}
