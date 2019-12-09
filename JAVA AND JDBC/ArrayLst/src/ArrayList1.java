import java.util.ArrayList;

public class ArrayList1 {
	public static void main(String[] args) {
		
		ArrayList<String> a1=new ArrayList<String>();
		
		a1.add("vivek");
		a1.add("flsjf");
		a1.add("aman");
		a1.add("abhi");
		System.out.println(a1);

		a1.remove(new String("flsjf"));//we have to pass the object because of generic types
		System.out.println(a1);
		System.out.println("-------------------");
		System.out.println(a1.size());
		
		System.out.println(a1.isEmpty());
		
		ArrayList<String> a2=new ArrayList<String>();
		
		a2.add("reena");
		a2.add("ashwin");
		a2.add("megha");
		a2.add("ria");
		a2.add("reena");
		
		a1.addAll(a2);
		System.out.println("----------------------");
		System.out.println(a1);
		
		ArrayList<String> a3=new ArrayList<String>();
		
		a3.add("vivek");
		a3.add("ashwin");
		a3.add("reena");
		a3.add("ria");
		a3.add("aman");
		
		System.out.println(a3);
		System.out.println("------------------");
		a2.removeAll(a3);
		
		System.out.println(a2);
		
		System.out.println("--------------");
		
		a1.retainAll(a3);
		System.out.println(a1);
		System.out.println("--------------");
		
		System.out.println(a1.containsAll(a2)); 
	}

}
