
public class Calculator {
	int add(int a) {
		return a+a;
	}
	int add(int a, int b) {
		return a+b;
	}
	double add(double a) {
		return a+a;
	}
	static void multiply(int a) {
		System.out.println("the result of mul1 is "+(a*a));
	}
	static void multiply(int a, int b) {
		System.out.println("the result of mul2 is "+(a*b));
	}
	static double multiply(double a) {
		return (a*a);
	}

}
