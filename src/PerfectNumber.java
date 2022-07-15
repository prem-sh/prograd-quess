//Write a program to check whether given number is perfect or not.(6, 28, 496, 8128 )

import java.util.Scanner;
public class PerfectNumber {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please enter a number : ");
        int n = sc.nextInt();
        if (isPerfect(n)) System.out.println("! Perfect Number !");
        else System.out.println("X Not a Perfect Number X");
    }
    static Boolean isPerfect(int n){
        int sum = 0;
        for(int i = 1; i<n; i++)
            if(n%i == 0) sum+=i;
        if(sum == n) return true;
        return false;
    }
}
