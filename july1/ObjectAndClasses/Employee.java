package july1.ObjectAndClasses;

public class Employee {
	 
	String name;
	int id;
	double salary;
	String department;
	
	Employee(String name, int id, double salary, String department) { 
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.department = department;
	} 
	public void dispay() {
		System.out.println("Name : " + name );
		System.out.println("ID : " + id);
		System.out.println("Salary : " + salary );
		System.out.println("Department : " + department);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Employee e1 = new Employee("harry", 1, 25000.00, "CSE");
		e1.dispay();
		
		Employee e2 = new Employee("Candy", 2, 25000.50, "IT");
		e2.dispay();
		
		Employee e3 = new Employee("Lily", 3, 28000.00, "CSE");
		e3.dispay();	 
		 
	}
	
}
