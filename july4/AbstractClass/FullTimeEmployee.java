package july4.AbstractClass;

import java.util.Scanner;

public class FullTimeEmployee extends Employee{
	Scanner io = new Scanner(System.in);
	
	@Override
	void calculateSalary() {
		System.out.println("Enter Salry:");
		int sal = io.nextInt();
		System.out.println("Salary is : " + sal);
	}

}
