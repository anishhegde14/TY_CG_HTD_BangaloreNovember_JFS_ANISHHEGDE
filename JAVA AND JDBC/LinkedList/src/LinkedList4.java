import java.util.LinkedList;

public class LinkedList4 {
	
	public static void main(String[] args) {
		
		LinkedList l1=new LinkedList();
		
		l1.add(23);
		l1.add(63);
		l1.add(7);
		l1.add(98);
		l1.push(234);
		
		System.out.println(l1);
		
		l1.pop();
		
		System.out.println(l1);
		System.out.println(l1.element());
		System.out.println(l1);
	}

}
