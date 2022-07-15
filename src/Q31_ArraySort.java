//Task 31 : Write a java program to sort the given names.

import java.util.Scanner;
public class Q31_ArraySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements : ");
        for (int i = 0; i<n; i++) arr[i] = sc.nextInt();
        sort(arr);
        System.out.println("Sorted array is : ");
        for (int i = 0; i<n; i++) System.out.print(arr[i]+" ");
    };
    private static void sort(int[] arr){
        int i = 0, j = 0;
        for (;i<arr.length-1;i++){
            for (j=i+1;j< arr.length;j++){
                if (arr[i] > arr[j]){
                    arr[i]  += arr[j];
                    arr[j]  = arr[i] - arr[j];
                    arr[i] -= arr[j];
                }
            }
        }
    }
}

