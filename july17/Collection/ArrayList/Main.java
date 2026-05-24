package july17.Collection.ArrayList;
import java.util.ArrayList;
import java.util.*;

//ArrayList is a Java class implemented using the List interface. 
//Java ArrayList, as the name suggests, provides the functionality of a dynamic array 
//where the size is not fixed as an array. Also, as a part of the Collections framework, 
//it has many features not available with arrays.

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> li1 = new ArrayList<>();
		li1.add(11);//.add() Insert an element in this collection. 
		li1.add(22);
		li1.add(33);
		System.out.println("List1: " + li1);
		
		ArrayList<Integer> li2 = new ArrayList<>();
		li2.add(44); 
		li2.add(55);
		li2.add(66);
		
		li1.addAll(li2);//.addAll() Insert the specified collection elements in the invoking collection.
		System.out.println("List1+List2: " + li1);
		
		li2.addAll(1, li1);//.addAll(index, collection) Used to insert all of the elements starting at the specified position from a specific collection into the mentioned list.
		System.out.println("List2:" + li2);
		
		System.out.println("Idx of 11: " + li2.indexOf(11));//.indexOf() Returns the index the first occurrence of a specific element is either returned or -1 in case the element is not in the list.
		
		System.out.println("Element at Idx 3:" + li2.get(3));//.get() Returns the element at the specified position in this list.
		
		li1.remove(5);//.remove() Removes the element at the specified index in this list.
		System.out.println("List1:" + li1);
		
		System.out.println("List1 size: " + li1.size());//.size() Returns size of the list.
		
		System.out.println(li2.subList(3, 6));//.sublist(fromIndex, toIndex) Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
		 
		System.out.println(li1.isEmpty());//.isEmpty() Returns true if this list contains no elements.
		
		li1.clear();//.clear() Remove all the elements from any list.
		System.out.println(li1.isEmpty());
		
		Object[] array = li2.toArray();//.toArray() Return an array containing all of the elements in this list in the correct order same as the previous method.
		for(Object element : array) {
			System.out.println(element + " ");
		}
	}
}
