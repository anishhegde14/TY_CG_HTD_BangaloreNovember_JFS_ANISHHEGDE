class ElseIf{
	public static void main(String ar[]){
		int a=500;
		int b=60;
		int c=400;
		int d=5;
		
		if(a>b && a>c && a>d)
			System.out.println("a is greater");
		
		else if(b>c && b>d)
			System.out.println("b is greater");
		
		else if(c>d)
			System.out.println("c is greater");
		
		else
			System.out.println("d is greater");
	}
}