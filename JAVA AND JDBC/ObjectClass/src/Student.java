
public class Student {
	int studId;   
	String studName;
	public Student(int studId, String studName) {
		super();
		this.studId = studId;
		this.studName = studName;
	}
	public String toString() {
		return "the student id is: "+studId+" the student name is "+studName;
	}

}
