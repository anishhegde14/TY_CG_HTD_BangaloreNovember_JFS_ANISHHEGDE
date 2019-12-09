
public class InstanceBlock {
	final int MAXIMUM;
	static final double PI;
	
	InstanceBlock(){
		System.out.println("in constructor");
	}
	InstanceBlock(int a){
		System.out.println("overloaded constructor");
	}
	
	{
		System.out.println("in instance initializer block");
		MAXIMUM=3000;
	}
	static{
		System.out.println("static initilizer block executed");
		PI=3.142;
	}
}
