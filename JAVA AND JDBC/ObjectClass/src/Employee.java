
public class Employee {
	int studId;
	String studName;
	public Employee(int studId, String studName) {
		super();
		this.studId = studId;
		this.studName = studName;
	}
	@Override
	public String toString() {
		return "Employee [studId=" + studId + ", studName=" + studName + "]";
	}
	

}
