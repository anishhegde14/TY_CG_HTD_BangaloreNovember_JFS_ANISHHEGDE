
public class TestQspides {
	public static void main(String[] args) {
		Qspiders rajajinagar=new Qspiders();
		rajajinagar.swipe();
		rajajinagar.swipe();
		Qspiders BTM=new Qspiders();
		BTM.swipe();
		System.out.println(rajajinagar.branchStudCount);
		System.out.println(BTM.branchStudCount);
		System.out.println(Qspiders.totalStudCount);
	}
}
