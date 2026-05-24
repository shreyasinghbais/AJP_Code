package july16.CustomException; 

public class User {
	private String email;  
	
	public User(String email) throws InvalidEmailException {
		super();
		this.email = email;
		if(email.contains("@")) {
			System.out.println("Registered successfully.");
		}
		else {
			throw new InvalidEmailException("This Email is not valid.");
		}
	}
	public User() {}
	
}
