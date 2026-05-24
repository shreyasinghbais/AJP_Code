package july23.Collection.HashMap;
import java.util.*;
import java.util.Map.Entry;
public class Frequency {
	public static void main(String[] args) {
		String[] fruits = {"apple", "banana", "grapes", "orange", "apple", "orange", "mango", "banana", "apple", "orange", "grapes", "apple"};
		HashMap<String, Integer> fruitFrequency = new HashMap<>();
		for(String fruit : fruits) {
			if(fruitFrequency.containsKey(fruit)) {
				fruitFrequency.put(fruit, fruitFrequency.get(fruit)+1);
			}
			else {
				fruitFrequency.put(fruit, 1);
			}
		} 
		
		for( Entry<String, Integer> e : fruitFrequency.entrySet()) {
			System.out.println(e.getKey() + " -> " +e.getValue());
		}
	}
}
