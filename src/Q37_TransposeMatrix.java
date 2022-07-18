// 37 Transpose matrix
import java.util.Scanner;

public class Q37_TransposeMatrix {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter size of the Matrix : ");
        int row = input.nextInt();
        int col = input.nextInt();
        int[][] matrix = new int[row][col];
        int[][] transpose = new int[col][row];

        System.out.print("Enter Matrix elements ("+row*col+") : ");
        for (int i=0; i<row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j < col; j++) {
                transpose[j][i]=matrix[i][j];
            }
        }
        System.out.println("=== Input matrix ===\n");

        for (int i=0; i<row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("=== Transpose matrix ===\n");
        for (int i=0; i<col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(transpose[i][j]+" ");
            }
            System.out.println();
        }
    }
}
