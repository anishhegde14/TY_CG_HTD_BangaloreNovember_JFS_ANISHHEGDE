import java.util.Iterator;
import java.util.TreeSet;

public class TestPerson {
	
	public static void main(String[] args) {
		 
		TreeSet<Person> t=new TreeSet<Person>();
		
		t.add(new Person(22,"abhi"));
		t.add(new Person(67,"ai"));
		t.add(new Person(12,"vivek"));
		t.add(new Person(22,"ani"));
		
		Iterator<Person> itr=t.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
