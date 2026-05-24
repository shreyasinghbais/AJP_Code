package july9.FinalKeyword;

//Write a Java program to demonstrate the use of final methods. Create a class called FinalMethodDemo 
//with a final method calculateArea() that takes a double parameter radius and returns the area of a circle. 
//Try to override the calculateArea() method in a subclass and observe the error.

public class FinalMethodDemo {
	final double calculateArea(double r) {
		double area = 3.14*(r*r);
		return area;
	}
}
class Demo extends FinalMethodDemo{
	public static void main(String[] args) {
		FinalMethodDemo d = new FinalMethodDemo();
		System.out.println(d.calculateArea(2.0));
		
	}
	final double calculateArea(double r) {//Cannot override the final method from FinalMethodDemo
		double area = 3.14*r*r;
		System.out.println("Area of circle with radius r = " + r + " is: ");
		return area;
	}
	
}
//Hence we can't override the final methods.
