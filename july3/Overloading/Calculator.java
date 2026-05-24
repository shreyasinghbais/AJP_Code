package july3.Overloading;

public class Calculator {
	static double area(double r) {
		double areaOfCircle = 3.14*r*r;
		return areaOfCircle;
	}
	static double area(double l, double b) {
		double areaOfRect = l*b;
		return areaOfRect;
	}
	static double area(double base, double height, double width) {
		double areaOfTri = (base*height)/2;
		return areaOfTri;
	}
	public static void main(String[] args) {
		System.out.println(area(5.0));
		System.out.println(area(2.0, 10.2));
		System.out.println(area(100.1, 200.2, 30.3));
	}
	
	
}
