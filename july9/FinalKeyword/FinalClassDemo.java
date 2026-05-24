package july9.FinalKeyword;

//Final Classes
//
//Write a Java program to demonstrate the use of final classes. Create a final class called FinalClassDemo 
//with a method printMessage() that prints a message to the console. Try to create a subclass of FinalClassDemo 
//and observe the error.

final class FinalClassDemo {
	public void printMessage() {
		System.out.println("Hello...");
	}
}
class Try extends FinalClassDemo{ //Error The type Try cannot subclass the final class FinalClassDemo, remove final modifier.
	public static void main(String[] args) {
		FinalClassDemo d1 = new FinalClassDemo();
		d1.printMessage();
	}
}
//Hence we can't inherit the final class.