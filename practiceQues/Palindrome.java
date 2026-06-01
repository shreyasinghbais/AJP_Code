package ques;

import java.util.Scanner;

public class Palindrome {
	static Scanner io = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Enter a string to check whether it is a palindrome or not.");
        String s1 = io.nextLine();
        checkPalindrome(s1);

    }

    public static void checkPalindrome(String str) {
        int l = str.length();
        boolean isPalindrome = true;
        
        for (int i = 0; i < l / 2; i++) {
            if (str.charAt(i) != str.charAt(l - i - 1)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Given string is a palindrome.");
        } else {
            System.out.println("Given string is not a palindrome.");
        }
    }
}
