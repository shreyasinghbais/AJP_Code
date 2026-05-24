package practiceQues;

import java.util.Scanner;

public class ArmstrongNo {
	//Main class
	public static void main(String[] args) {
		Scanner io = new Scanner(System.in);
		System.out.println("Enter any No.");
		int number = io.nextInt();
		System.out.println("Armstron Number: " + isArmstrong(number));
		io.close();
	}
	//method to check the no. is Armstrong or not
	public static boolean isArmstrong(int n) {
		int digitCount = 0;
		int sum = 0;
		int temp;
		temp = n;
		//loop to count digits of no.
		while(temp>0) {
			temp = temp/10;
			digitCount++;
		}
		System.out.println("Number of digits: " + digitCount);
		temp = n;
		//loop to get sum of digit^digitCount
		while(temp>0) {
			int lastDigit = temp%10;
			sum = (int) (sum + Math.pow(lastDigit, digitCount));
			temp = temp/10;
		} 
		if(sum==n) {
			return true;
		}
		return false;
	}
}
