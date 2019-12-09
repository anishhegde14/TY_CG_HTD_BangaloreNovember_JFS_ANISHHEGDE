import java.util.HashSet;

public class HashSet2 {
	
	public static void main(String[] args) {
		
		HashSet<Student> hs=new HashSet<Student>();
		
		hs.add(new Student("Divya", 22));
		hs.add(new Student("anu", 23));
		hs.add(new Student("Ramesh", 25));
		hs.add(new Student("shree", 27));
		hs.add(new Student("Divya", 22));
		
		for (Student s : hs) {
			System.out.println(s.studName+" and age is "+s.studAge);
			
			
		}
		
	}

}
