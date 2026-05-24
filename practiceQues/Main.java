package practiceQues;
//there is array int[] arr   = {2,3,5,8,7,6} you have to find out two number whose sum is 12
public class Main {
	public static void main(String[] args) {
		int arr[] = {2,3,5,8,7,6};
		for(int i=0; i<arr.length; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if(arr[i]+arr[j]==12) {
					System.out.println("Two nums whose sum is 12 is " + arr[i] + "and " + arr[j]);
				} 
			}
		} 
 
	}
}
