package encapsulation;

import java.io.Serializable;

public class Person implements Serializable {
	private int age;
	private String name;
	
	public void setAge(int age) {
		this.age=age;
		
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name=name;
		
	}
	public String getName() {
		return name;
	}

}
