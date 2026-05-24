package july5.Interface;

import java.util.Scanner;

public class CreditCard implements PaymentMethod{
	Scanner io = new Scanner(System.in);
	String cardNo;
	String expDate;
	long amount;

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("Enter your Card Number: ");
		cardNo = io.next();
		System.out.println("Enter Expiry Date of your Card: ");
		expDate = io.next();
		System.out.println("Enter amount to pay: ");
		amount = io.nextLong();
		
	}

	@Override
	public void getPaymentDetails() {
		// TODO Auto-generated method stub
		System.out.println("Amount of "+ amount + "Rs. is paid by " + cardNo + " which is expiring on " + expDate);
		
	}

}
