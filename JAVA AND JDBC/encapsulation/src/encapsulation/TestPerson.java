package encapsulation;

public class TestPerson {
	public static void main(String[] args) {
		Person p=new Person();
		
		p.setAge(23);
		p.setName("Vivek");
		
		System.out.println(p.getAge());
		System.out.println(p.getName());
	}

}
