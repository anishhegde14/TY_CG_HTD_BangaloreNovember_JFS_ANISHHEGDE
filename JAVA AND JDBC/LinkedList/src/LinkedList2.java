import java.util.LinkedList;

public class LinkedList2 {
	public static void main(String[] args) {
		
		LinkedList l1=new LinkedList();
		
		l1.add(23);
		l1.add(65);
		
		System.out.println(l1);
		
		l1.addFirst(45);
		
		System.out.println(l1);
		
		l1.addLast(89);
		
		System.out.println("===========remove()===========");
		
		l1.remove();
		System.out.println(l1);
		
		System.out.println("=============removeFirst and removeLast=============");
		
		l1.removeFirst();
		System.out.println(l1);
		
		System.out.println("==========");
		
		l1.removeLast();
		
		System.out.println("==============================");
		
		LinkedList l2=new LinkedList();
		
		l2.add(22);
		l2.add(25);
		l2.add(20);
		l2.add(22);
		l2.add(34);
		
		l2.removeFirstOccurrence(22);
		l2.removeLastOccurrence(22);
	
		System.out.println(l2);
		
		System.out.println(l2.getFirst());
	}

}
