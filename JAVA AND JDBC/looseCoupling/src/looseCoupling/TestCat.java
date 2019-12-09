package looseCoupling;

public class TestCat {
	public static void main(String[] args) {
		Cat c1=new Cat();
		
		Lays l=new Lays();
		Kurkure k=new Kurkure();
		Bingo b= new Bingo();
		
		c1.feed(b);
	}

}
