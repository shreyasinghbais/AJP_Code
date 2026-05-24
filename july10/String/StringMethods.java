package july10.String; 

//Write a Java program to check if a String contains a specific substring using the contains() method.



public class StringMethods {
	public static void main(String[] args) {
		String s = "Wellcome to Java Programing";
		System.out.println("Original String is: " + s);
		
		//Java program to convert a String to uppercase using the toUpperCase() method.
		System.out.println(s.toUpperCase());
		
		//Java program to check if a String contains a specific substring using the contains() method.
		System.out.println(s.contains("to"));
		System.out.println(s.contains("the"));
		
		//Java program to get the length of a String using the length() method.
		System.out.println(s.length());
		
		//Java program to trim the whitespace from a String using the trim() method.
		String s1 = "     Hello, What is your name?      ";
		System.out.println("s1 before trim method: " + s1);
		System.out.println("s1 after trim method: " + s1.trim());
	}
}
