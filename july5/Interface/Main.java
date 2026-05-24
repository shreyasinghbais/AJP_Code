package july5.Interface;

public class Main {
	public static void main(String[] args) {
		Printable d = new Doc();
		Printable i = new Img();
		d.print();
		i.print();
		System.out.println();
		PaymentMethod p1 = new CreditCard();
		p1.pay();
		p1.getPaymentDetails();
		System.out.println();
		PaymentMethod p2 = new PayPal();
		p2.pay();
		p2.getPaymentDetails();
	}
}
