class Methods{
	static void add(int a, int b){
		System.out.println("the result is "+(a+b));
	}
	static void subtract(int a, int b){
		System.out.println("the result is "+(a-b));
	}
	static void multiply(int a, int b){
		System.out.println("the result is "+(a*b));
	}
	static void modulus(int a, int b){
		System.out.println("the result is "+(a%b));
	}
	static void divide(int a, int b){
		System.out.println("the result is "+(a/b));
	}

	public static void main(String []arr){
		add(40,30);
		subtract(40,30);
		multiply(3,8);
		modulus(10,5);
		divide(40,20);
	}
}