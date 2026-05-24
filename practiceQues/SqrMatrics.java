package practiceQues;
import java.util.*;
public class SqrMatrics {
	public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        System.out.println("Enter size of metrics: ");
        int N = io.nextInt();
        int[][] matrix = new int[N][N];
        System.out.println("Enter elements of metrics: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = io.nextInt();
            }
        }  
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        io.close();
    }
}
