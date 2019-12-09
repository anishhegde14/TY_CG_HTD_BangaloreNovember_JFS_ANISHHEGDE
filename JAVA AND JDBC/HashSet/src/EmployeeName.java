import java.util.Comparator;

public class EmployeeName implements Comparator<Employee2> {


	@Override
	public int compare(Employee2 o1, Employee2 o2) {
		return o1.name.compareTo(o2.name);
	}

}
