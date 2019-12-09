package ArrayList;

import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {
	
	public static void main(String[] args) {
		
		Collection c1 = new ArrayList();
		//adding elements
		c1.add(12);
		System.out.println(c1);
		//removing element
		c1.remove(12);
		System.out.println(c1);
		//size of ArrayList
		System.out.println(c1.size());
		//checking whether the ArrayList is empty or not
		System.out.println(c1.isEmpty());
		
		c1.add(12);
		
		System.out.println(c1.contains(12));
		
		
	}

}
