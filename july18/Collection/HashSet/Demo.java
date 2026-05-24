package july18.Collection.HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
 


public class Demo {
	public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        
        String sentence = io.nextLine();
        String[] words = sentence.split(" ");
        
        HashSet<String> result = new HashSet<>(Arrays.asList(words));
        ArrayList<String> resultList = new ArrayList<>(result);
        Collections.sort(resultList);
        System.out.println(resultList);
        
        io.close();
	}
}
