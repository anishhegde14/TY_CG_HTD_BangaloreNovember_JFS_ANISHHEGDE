
public class Test {
	public static void main(String[] args) {
		int i=10;
		//boxing
		Integer i1=new Integer(i);
		//unboxing
		int i2=i1.intValue();
		
		System.out.println(i);
		System.out.println(i1);
		System.out.println(i2);
		
		double d=13.23;
		//boxing
		Double d1=new Double(d);
		//unboxing
		double d2=d1.doubleValue();
		
		System.out.println(d);
		System.out.println(d1);
		System.out.println(d2);
	}

}
