package accessSpecifier;

public class TestPerson {
	public static void main(String[] args) {
		Person p=new Person("john");
		//private constructor , variable and method is not visible outside th
		//class thats why we can not create object of that constructor in other class;
//		System.out.println(p.name);
//		p.details();
	}

}
