package practiceQues;

import java.util.Scanner;

public class PhoneNumberFormatter {

    public static String formatPhoneNumber(String phoneNumber) {
        // Validate input length
        if (phoneNumber == null || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits long");
        }

        // Format the phone number
        return phoneNumber.substring(0, 3) + "-" +
               phoneNumber.substring(3, 6) + "-" +
               phoneNumber.substring(6);
    }

    public static void main(String[] args) {
    	System.out.println("Enter number: ");
    	Scanner io = new Scanner(System.in);
        String input = io.nextLine();
        String formatted = formatPhoneNumber(input);
        System.out.println("Formatted Phone Number: " + formatted);
        io.close();
    }
}


 
