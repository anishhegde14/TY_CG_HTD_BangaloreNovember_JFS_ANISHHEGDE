package com.tyss.typecasting.pack2;

public class TestAnimal {
	public static void main(String[] args) {
		Animal a=new Animal();
		Dog d=new Dog();
		Animal a1=new Dog();
		Dog d1=(Dog)a1;
		d.walk();
		a.eat();
		d1.walk();
		d1.walk();
	}
}
