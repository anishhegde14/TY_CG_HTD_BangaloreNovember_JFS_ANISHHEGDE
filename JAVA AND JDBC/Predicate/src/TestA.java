import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestA {
	public static void main(String[] args) {
		
		System.out.println("---------------predicate------------");
		Predicate<Integer> p=i -> i%2==0;
		
		boolean b1=p.test(12);
		System.out.println(b1);
		System.out.println(p.test(45));
		
		System.out.println("---------------Function---------------");
		Function<Integer, Integer> f1= i -> i*100;
		
		int a =f1.apply(86);
		
		System.out.println(a);
		
		System.out.println("---------------supplier----------------");
		
		Supplier<Student> s1= ()-> new Student(24,"anu");
		
		System.out.println(s1.get().getAge());
		System.out.println(s1.get().getName());
		
		System.out.println("------------------consumer---------------");
		Consumer<Student> c1=j ->{
			System.out.println(j.getAge());
			System.out.println(j.getName());
		};
		Student s=new Student(24, "anu");
		c1.accept(s);
		
	}

}
