import java.util.Scanner;
public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of First Matrix : ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        System.out.print("Enter size of Second Matrix : ");
        if(sc.nextInt() != row || sc.nextInt() != col){
            System.out.println("Error : Matrix size should be same to be added ");
            System.exit(1);
        }

        int[][] aMatrix = new int[row][col];
        int[][] bMatrix = new int[row][col];
        int[][] sum = new int[row][col];
        System.out.println("== Input of First Matrix ==");
        for(int i = 0; i<row; i++){
            System.out.print("row "+(i+1)+" > ");
            for (int j = 0; j<col; j++){
                aMatrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("== Input of Second Matrix ==");
        for(int i = 0; i<row; i++){
            System.out.print("row "+(i+1)+" > ");
            for (int j = 0; j<col; j++){
                bMatrix[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i<row; i++){
            for (int j = 0; j<col; j++){
                sum[i][j] = aMatrix[i][j]+bMatrix[i][j];
            }
        }

        System.out.println("== Sum of First and Second Matrices ==");
        for(int i = 0; i<row; i++){
            for (int j = 0; j<col; j++){
                sum[i][j] = aMatrix[i][j]+bMatrix[i][j];
            }
        }
        for(int i = 0; i<row; i++){
            for (int j = 0; j<col; j++){
                System.out.print(sum[i][j]+" ");
            }
            System.out.println();
        }

    }
}
