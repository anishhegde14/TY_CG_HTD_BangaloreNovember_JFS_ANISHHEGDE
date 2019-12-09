import java.util.Comparator;

public class EmployeeAge implements Comparator<Employee2> {

	@Override
	public int compare(Employee2 o1, Employee2 o2) {
		if(o1.age>o2.age)
			return 1;
		else if(o1.age<o2.age)
			return -1;
		else
			return 0;
	}
	

}
