
public class Person implements Comparable<Person> {
	
	int age;
	String name;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public int compareTo(Person o) {
		if(this.age> o.age) {
			return 1;
		}
		else if(this.age< o.age) {
			return -1;
		}
		else {
			return 0;
		}
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	
	

}
