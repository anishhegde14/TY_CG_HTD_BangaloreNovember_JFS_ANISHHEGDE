import java.util.LinkedList;

public class LinkedList3 {
	public static void main(String[] args) {

		LinkedList l1=new LinkedList();

		l1.add(23);
		l1.add(65);
		l1.add(89);
		l1.add(63);
		System.out.println("==============peek============");
		System.out.println(l1.peek());


		System.out.println(l1.peekFirst());

		System.out.println(l1.peekLast());



		System.out.println("===========poll===========");

		System.out.println(l1.poll());

		System.out.println(l1.pollFirst());

		System.out.println(l1.pollLast());

		System.out.println("=============offer=============");

		l1.offer(34);

		l1.offerFirst(99);

		l1.offerLast(100);

		System.out.println(l1);
	}
}
