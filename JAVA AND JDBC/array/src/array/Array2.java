package array;

public class Array2 {
	public static void main(String[] args) {
		double arr[]=new double[4];
		arr[0]=10.9;
		arr[1]=20;
		arr[2]=30.5;
		arr[3]=40;
		
		System.out.println(arr.length);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
