//Task 28 : Find the sum of 1 to n numbers using recursion.

import java.util.Scanner;
public class Q28_SumRange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int n = input.nextInt();
        if(n<=1){
            System.out.println("Please Enter a number more than 1");
            System.exit(1);
        }
        int result = addRange(n);
        System.out.println("Addition of numbers 1.."+n+" is "+result);
    }
    public static int addRange(int n){
        if(n==1) return 1;
        else return n+addRange(n-1); //recursive call
    }
}
