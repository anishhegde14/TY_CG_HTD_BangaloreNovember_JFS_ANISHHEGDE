
public class TestAnimal {
	public static void main(String[] args) {
		Lion l= new Lion();
		l.eat();
		
		Cat c=new Cat();
		c.eat();
		
		Animal a=new Animal();
		a.eat();
		
		Animal a1=new Lion();
		a1.eat();
	}

}
