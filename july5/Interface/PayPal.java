package july5.Interface;

import java.util.Scanner;

public class PayPal implements PaymentMethod{
	Scanner io = new Scanner(System.in);
	String email;
	long amount;
	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("Enter your Email id: ");
		email = io.next();
		System.out.println("Enter amount to pay: ");
		amount = io.nextLong();
		
	}

	@Override
	public void getPaymentDetails() {
		// TODO Auto-generated method stub
		System.out.println("Amount of "+ amount + "Rs. is paid by " + email);
		
	}

}
