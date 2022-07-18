//Task 32 :   JAVA program to count a total number of unique elements in an array.


import java.util.Scanner;

public class Q32_CountUnique {
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

        int count = n;
        //checking unique
        for (int i = 0; i<n-1; i++){
            if(arr[i] == null) continue;
            for (int j = i+1;j<n;j++){
                if(arr[j] == null) continue;
                if(arr[i].equalsIgnoreCase(arr[j])){
                    count--;
                    arr[j] = null;
                }
            }
        }
        System.out.println("Total number of uniques : "+count);
    }
}
