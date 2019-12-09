
public class Person {
	static int age;
	String name;
	void personDetails() {
		System.out.println("the name of the person is "+name+" and age is "+age);
		personDetailsStatic();
	}
	static void personDetailsStatic() {
		System.out.println(age);
	}
	void initialize(int a, String b) {
		age=a;
		name=b;
	}
}
