//Task 35 :   JAVA program to find maximum and minimum number from given array by passing array to the function.

import java.util.Scanner;

public class Q35_MaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements : ");
        for (int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        findMinMax(arr);
    }
    public static void findMinMax(int[] arr){
        int min = arr[0], max = 0;
        for (int i : arr){
            min = i<min ? i:min;
            max = i>max ? i:max;
        }
        System.out.println("Maximum number : "+max);
        System.out.println("Minimum number : "+min);
    }
}
