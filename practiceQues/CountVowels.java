package practiceQues;

import java.util.Scanner;

//Design a Java function that takes a sentence as input, counts the number of vowels, 
//and prints the result. Handle cases where no vowels are present.
public class CountVowels {
	static Scanner io = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter any sentence: ");
		String sentence = io.nextLine();
		vowelCount(sentence);
	}
	
	public static void vowelCount(String sentence) {
		int count = 0;
		for(int i=0; i<sentence.length(); i++) {
			if((sentence.charAt(i)=='a')||(sentence.charAt(i)=='e')||(sentence.charAt(i)=='i')||(sentence.charAt(i)=='o')||(sentence.charAt(i)=='u')) {
				count++;
			}
		}
		if(count==0) {
			System.out.println("Sentence does not contain any vowels.");
		}
		else {
			System.out.println("Vowels Count = " + count);
		}
	}  
}
