//Task 31 : Write a java program to sort the given names.

import java.lang.reflect.Array;
import java.util.Scanner;
public class Q31_ArraySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size : ");
        int n = sc.nextInt();
        String[] arr = new String[n];
        System.out.println("Enter array elements : ");
        for (int i = 0; i<n; i++) {
            arr[i] = sc.nextLine();
            if(arr[i].isEmpty()) i--;
        }
        sort(arr);
        System.out.print("Sorted array is : ");
        for (int i = 0; i<n; i++) System.out.print(arr[i]+" ");
    };
    private static void sort(String[] arr){
        int i = 0, j = 0;
        for (;i<arr.length-1;i++){
            for (j=i+1;j< arr.length;j++){
                if (!lesserThan(arr[i], arr[j])){
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    static boolean lesserThan(String str1, String str2){
        int len = str1.length();
        if(str1.length() > str2.length()){
            len = str2.length();
        }
        for (int i=0; i<len; i++){
            if(str1.charAt(i) > str2.charAt(i)){
                return false;
            } else if (str1.charAt(i) < str2.charAt(i)) {
                return true;
            }else {
                continue;
            }
        }

        return true;
    }
}

