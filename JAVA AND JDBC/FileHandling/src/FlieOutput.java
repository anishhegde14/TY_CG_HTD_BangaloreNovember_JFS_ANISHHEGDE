import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FlieOutput {
	
	public static void main(String[] args) {
		
		try {
			FileOutputStream f1=new FileOutputStream("anu.txt");
			String s="Divya Bogar";
			byte b[]=s.getBytes();
			f1.write(b);
			System.out.println("success..");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
