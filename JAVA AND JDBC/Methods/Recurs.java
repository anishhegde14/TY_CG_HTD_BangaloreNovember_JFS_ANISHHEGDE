class Recurs{
	static int factorial(int a){
		if(a==0){
			return 1;
		}
		
		return a * factorial(a-1);
	}

	public static void main(String arr[]){
		int result=factorial(5);
		System.out.println("Factorial of 5 is "+result);
	}
}