package july4.AbstractClass;

public class Main {
	public static void main(String[] args) {
		Employee e1 = new FullTimeEmployee();
		e1.calculateSalary();
		Employee e2 = new PartTimeEmployee();
		e2.calculateSalary();
	}
}
