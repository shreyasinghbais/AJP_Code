package july10.String;

//Java program to split a String into an array of substrings using the split() method.

public class StringSplit {
	public static void main(String[] args) {
		String s = "Use of split menthod of String";
		System.out.println(s);
		String arr[] = s.split(" ");
		for(int i=0; i<arr.length; i++) {
			System.out.println(i+1 + ": " + arr[i]);
		}
	}
}
