//Reverse Array Traversal
//
//Description
//• You are given an array, stored in a variable with the name arr
//The size of the array is stored in a variable with the name size
//• You have to print the reverse traversal of the array
//• For example, consider the value stored in size = 4 and the array is arr = [1 2 3 4] Then, the required output will be arr = [4 3 2 1]
//Input
//• The first line of the input contains the value stored in size
//Them the required output will be
//• The next line of the input contains the values stored in the array. All the values are on a single line separated by space
//Output
//• You have to print the reverse traversal of the array as shown in the problem statement
//
//Sample input 
//5
//1 2 3 4 5
//
//Sample output
//
//5 4 3 2 1

package practiceQues;

import java.util.*;

public class RevArray {
	public static void main(String[] args) {
		Scanner io = new Scanner(System.in);
		System.out.println("Enter Size of Array: ");
		int size = io.nextInt();
		System.out.println("Enter Elements of Array: ");
		int arr[] = new int[size];
		for(int i=0; i<arr.length; i++) {
			arr[i]=io.nextInt();
		}
		System.out.println("The reversed Array is: ");
		for(int i=arr.length-1; i>=0; i--) {
			System.out.print(arr[i]+" ");
		}
		io.close();
		
	}

}
