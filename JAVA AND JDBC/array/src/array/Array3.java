package array;

public class Array3 {
	public static void main(String[] args) {
		char arr[]=new char[5];
		arr[0]='v';
		arr[1]='i';
		arr[2]='v';
		arr[3]='e';
		arr[4]='k';
		
		System.out.println(arr.length);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
