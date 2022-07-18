//Task 34 :   JAVA program to input n number of elements in an array and separate them into even and odd two different arrays.

import java.util.Scanner;

public class Q34_SegrateOddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements : ");
        for (int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int odd[] = new int[n], even[] = new int[n];
        int oddTop = 0, evenTop = 0;
        for (int i : arr){
            if(i == 0) continue;
            if(i%2 == 0) even[evenTop++] = i;
            else  odd[oddTop++] = i;
        }

        //Print odd array
        System.out.print("Odd array : [ ");
        for(int i = 0; i<oddTop; i++) System.out.print(odd[i]+" ");
        System.out.print("]\n");

        //Print even array
        System.out.print("Even array : [ ");
        for(int i = 0; i<evenTop; i++) System.out.print(even[i]+" ");
        System.out.print("]\n");
    }
}
