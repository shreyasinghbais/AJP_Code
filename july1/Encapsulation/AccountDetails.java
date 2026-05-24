package july1.Encapsulation;

public class AccountDetails {
	private String name;
	private long accNo;
	private String ifsc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
	public AccountDetails(String name, long accNo, String ifsc) {
		super();
		this.name = name;
		this.accNo = accNo;
		this.ifsc = ifsc;
	}
	public AccountDetails() {}
	
	public void display() {
		System.out.println("Username:" + name);
		System.out.println("Account Number:" + accNo);
		System.out.println("IFSCode:" + name);
	}
}
