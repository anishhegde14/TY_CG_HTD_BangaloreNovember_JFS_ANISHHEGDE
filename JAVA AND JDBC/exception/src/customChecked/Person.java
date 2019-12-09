package customChecked;

public class Person {
	public static void main(String[] args) {
		System.out.println("main started");
		
		Election a=new Election();
		try {
		a.vote(19);
		}
		catch(AgeLimitException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main ended");
	}

}
