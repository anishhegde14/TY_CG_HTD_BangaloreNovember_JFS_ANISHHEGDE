package ArrayList;

import java.util.ArrayList;
import java.util.Collection;

public class Collection2 {

	public static void main(String[] args) {

		Collection c1 = new ArrayList();

		c1.add("vivek");

		c1.add(12);

		c1.add("abhishek");

		c1.add(23.4);

		System.out.println(c1);

		Collection c2 = new ArrayList();

		c2.add(23);
		c2.add("ani");

		c1.addAll(c2);
		System.out.println("-----------addAll-------------");
		System.out.println(c1);
		
		Collection c3=new ArrayList();
		
		c3.add(23);
		c2.removeAll(c3);
		
		System.out.println("----------------removeAll-----------");
		
		System.out.println(c2);
		
		System.out.println("------------reatailAll-----------");
		c1.retainAll(c3);
		System.out.println(c1);
		System.out.println("------------containsAll-------------");
		System.out.println(c1.containsAll(c3));
		
		Collection c6 =new ArrayList();
		
		c6.add(223);
		c6.add(23);
		
		Object ar[]=c6.toArray();
		System.out.println("--------toArray--------");
		for(int i=0;i<ar.length;i++) {
			System.out.println(ar[i]);
		}
	}

}
