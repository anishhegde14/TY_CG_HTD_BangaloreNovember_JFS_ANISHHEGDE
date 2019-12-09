import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class List1 {

	public static void main(String[] args) {

		List<Integer> l1= new ArrayList();

		l1.add(0, 23);
		l1.add(1, 24);
		l1.add(2, 27);
		l1.add(3, 23);
		l1.add(4, 29);
		l1.add(5, 200);
		System.out.println(l1);

		l1.add(1,400);

		System.out.println(l1);

		l1.remove(2);
		System.out.println(l1);

		l1.add(110);
		System.out.println(l1);

		System.out.println(l1.indexOf(400));

		System.out.println(l1.lastIndexOf(110));
		System.out.println("-----------------------");

		for(int i=0; i<l1.size();i++) {
			System.out.println(l1.get(i));
		}
		System.out.println("=========forEach=============");
		for (Object i : l1) {
			System.out.println(i);
			
		}
		System.out.println("==========iterator==========");
		Iterator<Integer> itr=l1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("---------------------");
		System.out.println("==============ListIterator==========");
		ListIterator<Integer> itr1 = l1.listIterator(l1.size());
		while(itr1.hasPrevious()) {
			System.out.println(itr1.previous());
		}
		System.out.println("----------------------");
		List l2 = new ArrayList();
		l2.add(45);
		l2.add(88);

		l1.addAll(2, l2);
		System.out.println(l1);

		l2.set(0, 100);
		System.out.println(l2);

		List l5=new ArrayList();

		l5.add(11);
		l5.add(22);
		l5.add(66);

		List l6=l5.subList(0, 2);
		System.out.println(l6);
		System.out.println(l1.contains(27));
		l1.clear();
		System.out.println(l1);

	}

}
