//Prog to make a toggle case of given sentence i.e. Small letters to capital and vice versa

import java.util.Scanner;

public class ToggleCase {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Please Enter a String : ");
        System.out.println("Toggle case : "+toggleCase(sc.nextLine()));
    }

    public static String toggleCase(String str){
        char[] arr = str.toCharArray();
        for (int i=0; i<arr.length; i++){
            if(arr[i] >= 'A' && arr[i] <= 'Z') arr[i]+='a'-'A';
            else if(arr[i] >= 'a' && arr[i] <= 'z') arr[i]-='a'-'A';
        }
        return String.valueOf(arr);
    }
}
