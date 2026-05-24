package july23.Collection.HashMap;
import java.util.*;
import java.util.Map.Entry;
public class Map {
	public static void main(String[] args) {
		HashMap<String, Integer> m = new HashMap<>();
		m.put("A", 1);
		m.put("B", 2);
		m.put("C", 3);
		m.put("D", 4);
		m.put("E", 5);
		System.out.println(m);
		for(Entry<String, Integer> e : m.entrySet()) {
			System.out.println(e.getKey() + "-->" + e.getValue());
		}
	}
}
