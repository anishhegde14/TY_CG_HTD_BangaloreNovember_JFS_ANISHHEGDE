package com.tyss.access.pack2;
import com.tyss.access.pack1.*;//for static as well as non static calls
import static com.tyss.access.pack1.Person.*;//only for static import

public class TestPerson {
	public static void main(String[] args) {
		Person p=new Person("john");
		p.personName();
		personName2();
	}
}
