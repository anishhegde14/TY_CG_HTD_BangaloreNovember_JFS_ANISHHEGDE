import java.util.Vector;

public class Vetor1 {
	
	public static void main(String[] args) {
		
		Vector v1=new Vector();
		
		v1.add(23);
		v1.add(234);
		v1.add(267);
		v1.add(24);
		
		System.out.println(v1);
		
		v1.remove(new Integer(234));
		
		System.out.println(v1);
		
		for(int i=0;i<v1.size();i++) {
			System.out.println(v1.get(i));
		}
		v1.set(1, 69);
		System.out.println(v1);
		
		
		
	}

}
