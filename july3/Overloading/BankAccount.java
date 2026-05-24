package july3.Overloading;

public class BankAccount {
	static void amount(double a) {
		System.out.println("Amount is : " + a);
	}
	static void amount(double a, int i) {
		System.out.println("Amount is : " + a + " and Interest is : " + i);
	}
	public static void main(String[] args) {
		amount(2500.00);
		amount(1000.25, 50);
	}
}
