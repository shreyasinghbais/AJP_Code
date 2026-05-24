package practiceQues;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();


        // Convert to lowercase to ignore case sensitivity
        sentence = sentence.toLowerCase();

        // Create a StringTokenizer to split the sentence into words
        StringTokenizer tokenizer = new StringTokenizer(sentence);

        // Create a HashMap to store word frequencies
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Iterate through the tokens and count frequencies
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            word = word.replaceAll("[^a-zA-Z0-9]", ""); // Remove punctuation
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        // Display the unique words and their frequencies
        System.out.println("Word Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue()); 

        }
        scanner.close();
    }
}
