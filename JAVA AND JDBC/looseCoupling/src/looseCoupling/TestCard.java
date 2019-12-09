package looseCoupling;

public class TestCard {
	public static void main(String[] args) {
		Card c=new Card();
		AtmIcici a=new AtmIcici();
		HdfcAtm h=new HdfcAtm();
		SbiAtm s=new SbiAtm();
		
		c.iciciBank(h);
	}

}
