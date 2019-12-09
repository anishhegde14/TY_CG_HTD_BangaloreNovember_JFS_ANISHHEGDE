import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet2 {
	public static void main(String[] args) {
		
		LinkedHashSet<Employee> l=new LinkedHashSet<Employee>();
		
		l.add(new Employee(22,"Ramu"));
		l.add(new Employee(21,"amu"));
		l.add(new Employee(24,"Gunda"));
		l.add(new Employee(22,"Ramu"));
		
		Iterator itr=l.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());//we need to override the toString method
		}
		
	}
}
