
public class Employee {
	
	int age;
	String Name;
	public Employee(int age, String name) {
		super();
		this.age = age;
		Name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + age;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (age != other.age)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [age=" + age + ", Name=" + Name + "]";
	}
	

}
