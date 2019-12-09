package stringclass;

public class Demo10 {
	public static void main(String[] args) {
		
		StringBuffer s1=new StringBuffer("John");
		System.out.println(s1.hashCode());
		s1=s1.append(" Marsh");
		System.out.println(s1.hashCode());
		
		
	}

}
