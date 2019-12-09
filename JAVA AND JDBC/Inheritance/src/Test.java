
public class Test {
	public static void main(String[] args) {
//		FirstGeneration fg=new FirstGeneration();
//		fg.call();
//		fg.msg();
//		SecondGeneration sg=new SecondGeneration();
//		sg.call();
//		sg.msg();
//		sg.radio();
//		ThirdGeneration tg=new ThirdGeneration();
//		tg.call();
//		tg.msg();
//		tg.radio();
//		tg.camera();
		FirstGeneration fg=new SecondGeneration();
		fg.call();
		fg.msg();
		SecondGeneration sg=new ThirdGeneration();
		sg.call();
		sg.msg();
		sg.radio();
		FirstGeneration fg1=new ThirdGeneration();
		fg1.call();
		fg1.msg();
	}

}
