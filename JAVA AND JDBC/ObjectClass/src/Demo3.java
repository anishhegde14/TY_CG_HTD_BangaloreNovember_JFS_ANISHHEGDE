public class Demo3{//custom immutable class
	
	private String name;
	private int age;
	public Demo3(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
}