package july16.CustomException;

public class Demo {
	public static void ageCheck(int age) throws InvalidAgeException{
		if(age>=18) {
			System.out.println("You can vote");
		}
		else {
			throw new InvalidAgeException("You can't vote");
		}
	}
	public static void main(String[] args) {
		int age = 15;
		try {
			ageCheck(age);
		} catch (InvalidAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
