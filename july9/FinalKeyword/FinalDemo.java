package july9.FinalKeyword;

//Question 1: Final Variables
//
//Write a Java program to demonstrate the use of final variables. 
//Create a class called FinalDemo with a final instance variable 
//MAX_VALUE initialized to 100. Try to reassign the value of MAX_VALUE in the 
//constructor and observe the error.

public class FinalDemo {
	final int MAX_VALUE = 100;
	public FinalDemo(int MAX_VALUE) {
		this.MAX_VALUE = MAX_VALUE;	
		//The error is:
		//The final field FinalDemo.MAX_VALUE cannot be assigned, remove 'final' modifier of MAX_VALUE
	}
	public FinalDemo() {};
	public static void main(String[] args) {
		FinalDemo f = new FinalDemo();
		System.out.println(f.MAX_VALUE);
		FinalDemo f1 = new FinalDemo(99);
		System.out.println(f1.MAX_VALUE);
		//java.lang.Error: Unresolved compilation problem: 
		//The final field FinalDemo.MAX_VALUE cannot be assigned
	}
}
//Hence we can't re-assign the value of final variables.