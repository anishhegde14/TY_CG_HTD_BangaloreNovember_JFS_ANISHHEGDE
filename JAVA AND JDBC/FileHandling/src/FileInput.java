import java.io.FileOutputStream;

public class FileInput {
	public static void main(String[] args) {
		
		try {
			FileOutputStream f1=new FileOutputStream("anu.txt");
			int j=0;
			while((j = f1.read())!=-1){
				System.out.println((char)j);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}

}
