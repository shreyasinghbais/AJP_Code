package july3.Overriding;

public class Test {
	public static void main(String[] args) {
		
		Animal c = new Cat();
		c.sound();
		Animal d = new Dog();
		d.sound();
		System.out.println();
		Vehicle car = new Car();
		car.drive();
		Vehicle bike = new Motorcycle();
		bike.drive();
	}
}
