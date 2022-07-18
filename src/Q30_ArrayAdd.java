//Task 30 : Write a program in to find the sum and average of all elements of the array.
import java.util.Scanner;
public class Q30_ArrayAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size : ");
        int n = sc.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        System.out.print("Enter array elements : ");
        for (int i = 0; i<n; i++) arr[i] = sc.nextInt();
        System.out.print("Sum of ");
        for (int i = 0; i<n; i++) {
            System.out.print(arr[i]+" ");
            sum += arr[i];
        };
        System.out.print("is "+sum);

        System.out.print("\nAvg of ");
        for (int i = 0; i<n; i++) {
            System.out.print(arr[i]+" ");
        };
        System.out.print("is "+(double)sum/arr.length);
    }
}