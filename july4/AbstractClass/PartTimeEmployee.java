package july4.AbstractClass;

import java.util.Scanner;

public class PartTimeEmployee extends Employee{
	Scanner io = new Scanner(System.in);
	@Override
	void calculateSalary() {
		System.out.println("Enter Hourly Rate:");
		int hr = io.nextInt();
		System.out.println("Hourly Rate is: " + hr);
	}

}
