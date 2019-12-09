import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayList2 {
	public static void main(String[] args) {
		
		ArrayList<String> a1=new ArrayList<String>();
		
		a1.add(0, "vivek");
		a1.add(1, "aman");
		a1.add(2, "vikas");
		a1.add(3, "rohan");
		
		System.out.println(a1);
		System.out.println("--------------------");
		a1.remove(2);
		System.out.println(a1);
		
		System.out.println("---------------");
		ListIterator<String> itr=a1.listIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		while(itr.hasPrevious()) {
			System.out.println(itr.previous());
		}
	}
	
	

}
