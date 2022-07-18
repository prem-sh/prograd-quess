//Task 33 :   JAVA program to find the second largest element in an array.

import java.util.Scanner;

public class Q33_SecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements : ");
        for (int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int first = 0, second = 0;

        for (int i = 0; i<n-1; i++) {
            if(second < arr[i]) second = arr[i];
            if(first < second) {
                int temp = first;
                first = second;
                second = temp;
            }
        }

        System.out.println("Second largest number is : "+second);
    }
}
