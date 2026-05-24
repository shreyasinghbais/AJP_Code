package july1.Encapsulation;

public class Bank {
	public static void main(String[] args) {
		AccountDetails u1 = new AccountDetails("Harry", 123456, "xzsd2005");
		u1.display();
		u1.setAccNo(1234);
		u1.display();
		System.out.println();
		AccountDetails u2 = new AccountDetails("Peter", 897546, "qwer8005");
		u2.display();
	}
}
