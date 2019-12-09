class ForLoop{
	public static void main(String ar[]){

		for(int i=0;i<10;i++){
			System.out.println("the value is "+i);
		}
		System.out.println();

		for(int i=0;i<10;i++){
			if(i==5)
				continue;
			System.out.println("the value is "+i);
		}
		System.out.println();
		
		for(int i=0;i<10;i++){
			if(i==5)
				break;
			System.out.println("the value is "+i);
		}
	}
}