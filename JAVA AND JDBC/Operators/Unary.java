class Unary{
	public static void main(String[] ar){
		int x=20;

		int result=x++ + ++x + --x + ++x + --x;
		
		System.out.println("The resulting value is "+result);
	}
}