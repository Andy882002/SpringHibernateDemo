package demo.test;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp=new Employee();
		Employee emp2=new Employee();
		emp.setId(1000);
		emp.setName("Steven Oliver");
		emp2.setId(1001);
		emp2.setName("Julie Amander");
		System.out.println(emp.toString());
		
		System.out.printf("%s", emp.equals(emp2));
		

	}

}
