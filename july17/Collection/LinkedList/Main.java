package july17.Collection.LinkedList;
import java.util.LinkedList;


public class Main {
	public static void main(String[] args) {
		LinkedList<String> l1 = new LinkedList<>();
		l1.add("abc");//.add() Used to insert the specified element at the specified position in a list.
		l1.add("def");
		l1.add("ghi");
		l1.add("jkl");
		l1.add("mno");
		l1.add("prq");
		l1.add("stu");
		l1.add("vwx");
		l1.add("yz");
		System.out.println(l1);
		
		LinkedList<String> l2 = new LinkedList<>();
		l2.add("123");
		l2.add("456");
		l2.add("789");
		 
		l1.addAll(l2);//this method insert the specified collection elements in the invoking collection.
		System.out.println("L1+L2: " + l1);
		
		l1.addFirst("Hello");//This method Inserts the specified element at the beginning of this list.
		l1.addLast("End of LinkedList");//This method Appends the specified element to the end of this list.
		System.out.println(l1);
		
		System.out.println(l1.contains("456"));//This method returns true if this list contains the specified element.
		
		System.out.println(l1.getFirst());//This method returns the first element in this list.
		System.out.println(l1.getLast());//This method returns the last element in this list.
		
		System.out.println(l1.size());//This method returns the number of elements in this list.
		
		System.out.println(l1.indexOf("yz"));//This method returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
	}
}
