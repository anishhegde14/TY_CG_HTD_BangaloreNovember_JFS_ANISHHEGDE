
public class TestCalculator {
	public static void main(String[] args) {
		Calculator c=new Calculator();
		int r1= c.add(5);
		System.out.println("The result is "+r1);
		int r2= c.add(6,7);
		System.out.println("The result is "+r2);
		double r3= c.add(55.6);
		System.out.println("The result is "+r3);
		
		Calculator.multiply(3);
		Calculator.multiply(3, 5);
		double r=Calculator.multiply(4.5);
		System.out.println(r);
	}

}
