import java.util.HashSet;

public class HashSet1 {
	
	public static void main(String[] args) {
		
		HashSet hs=new HashSet();
		
		hs.add(23);
		hs.add(86);
		hs.add(12);
		hs.add(44);
		hs.add(23);
		hs.add(null);
		hs.add(null);
		
		for(Object o:hs) {
			System.out.println(o);
		}
		
		HashSet<String> hs1=new HashSet<String>();
		
		hs1.add("shree");
		hs1.add("divya");
		hs1.add("anu");
		hs1.add(null);
		
		for(String o:hs1) {
			System.out.println(o);
		}
	}
}
