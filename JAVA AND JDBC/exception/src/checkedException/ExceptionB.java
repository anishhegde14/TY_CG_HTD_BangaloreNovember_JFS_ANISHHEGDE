package checkedException;

public class ExceptionB {
	public static void main(String[] args) {
		System.out.println("main started");
	
	Student s1=new Student();
	
	
	try {
	Object s2= s1.clone();
	System.out.println("Object cloned");
	Class s3=Class.forName("Student");
	}
	catch(ClassNotFoundException e) {
		System.out.println("class not found");
	}
	catch(CloneNotSupportedException c) {
		System.out.println("clone not supported");
	}
	System.out.println("main ended");
}
}
