
package checkedException;

public class ExceptionC {
	public static void main(String[] args) {
		System.out.println("main started");
	
	Employee e1=new Employee();
	
	
	try {
	Object s2= e1.clone();
	System.out.println("Object cloned");
	try {
		Class s3=Class.forName("Student");
	}
	catch(ClassNotFoundException e) {
		System.out.println("class not found");
	}
	}
	catch(CloneNotSupportedException c) {
		System.out.println("clone not supported");
	}
	System.out.println("main ended");
}
}