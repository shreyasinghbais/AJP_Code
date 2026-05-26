package Main;

import java.util.Scanner;

public class Calculator {
	//Main method
	public static void main(String[] args) {
		calculation();
	}

	static Scanner io = new Scanner(System.in);
	
	//Implementation method
	public static void calculation() {
		char continueCalculation;
        do {
            System.out.println("----Welcome to Calculator----");
            System.out.println("Select an Operation to perform:");
            System.out.println("+, -, *, /"); 
            char ch = io.next().charAt(0);

            System.out.println("Enter 1st operand a:");
            int a = io.nextInt();

            System.out.println("Enter 2nd operand b:");
            int b = io.nextInt();

            switch (ch) {
                case '+':
                    Calculator.add(a, b);
                    break;
                case '-':
                    Calculator.subtract(a, b);
                    break;
                case '*':
                    Calculator.multiply(a, b);
                    break;
                case '/':
                    Calculator.divide(a, b);
                    break;
                default:
                    System.out.println("Invalid input selected.");
                    break;
            }
            System.out.println("Do you want to perform another calculation? (y/n)");
            continueCalculation = io.next().charAt(0);
        } while (continueCalculation == 'y' || continueCalculation == 'Y');
        System.out.println("Thank you for using the calculator. Goodbye!"); 
        io.close();
	}
	
	//Add method
	public static int add(int a, int b) { 
		int c = a+b;
		System.out.println(a+ " + " +b + " = " + c);
		return c;
	}
	
	//Subtract method
	public static int subtract(int a, int b) { 
		int c = a-b;
		System.out.println(a+ " - " +b + " = " + c);
		return c;
	}
	
	//Multiply method
	public static int multiply(int a, int b) { 
		int c = a*b;
		System.out.println(a+ " * " +b + " = " + c);
		return c;
	}
	
	//Divide method
	public static int divide(int a, int b) { 
		int c = a/b;
		System.out.println(a+ " / " +b + " = " + c);
		return c;
	}
}
