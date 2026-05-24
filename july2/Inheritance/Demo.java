package july2.Inheritance;

public class Demo {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.sound();
		System.out.println();
		SportsCar s1 = new SportsCar();
		s1.drive();
		System.out.println();
		Circle c1 = new Circle();
		double carea = c1.area( 5.0);
		System.out.println("Area of circle : " + carea);
		Rectangle r1 = new Rectangle();
		double rarea = r1.area(2.0, 5.0);
		System.out.println("Area of rectangle: " + rarea);
		
	}
	
}
