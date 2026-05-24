package july9.FinalKeyword;

//Final Parameters
//
//Write a Java program to demonstrate the use of final parameters. Create a method printMessage() that takes 
//a final String parameter message. Try to reassign the value of message within the method and observe the error.

public class FinalParameterDemo {
	public void printMessage(final String str) { 
		str=str.concat("java.");//Error The final local variable str cannot be assigned. 
		//It must be blank and not using a compound assignment
		System.out.println(str);
	}
	public static void main(String[] args) {
		FinalParameterDemo p = new FinalParameterDemo();
		p.printMessage("hello");
	}
}
////Hence we can't reassign the value of final parameter.