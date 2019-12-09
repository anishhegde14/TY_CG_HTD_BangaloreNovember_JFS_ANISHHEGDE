
public class NewPerson {
	public static void main(String[] args) throws Throwable {
		System.out.println("-------main started------");
		Person p=new Person("John");
		p.finalize();
		p=null;
		System.gc();
		System.out.println("----------main ended-----------");
		
	}

}
