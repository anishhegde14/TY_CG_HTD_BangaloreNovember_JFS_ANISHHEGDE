import java.util.TreeSet;

public class TreeSet2 {
	public static void main(String[] args) {
		
		TreeSet<Employee2> t=new TreeSet<Employee2>();
		
		t.add(new Employee2(22,3400,"john"));
		t.add(new Employee2(25,2400,"mikel"));
		t.add(new Employee2(22,5400,"mery"));
		
		for (Employee2 e : t) {
			System.out.println("employee name is "+e.name);
			System.out.println("employee salary is "+e.salary);
			System.out.println("employee age is "+e.age);
			System.out.println("-------------------------");
			
		}
	}
}
