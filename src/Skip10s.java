//Write a Java program to print all even numbers from 2 to n
// but skip the numbers whose unit digit is ‘0’. (Use of continue).

import java.util.Scanner;
public class Skip10s {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please enter a number : ");
        int n = sc.nextInt();
        if(n<2) System.out.println("Please enter number more than 2");
        for (int i = 2; i<=n; i+=2){
            if(i%10 == 0) {
                System.out.println();
                continue;
            }
            System.out.print(i+" ");
        }
    }
}
