//Task 27 : Find the table of given number using recursion

import java.util.Scanner;

public class Q27_RecursionTable {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Multiplier : ");
        int n = input.nextInt();
        printTable(n,10);
    }

    public static void printTable(int n, int m){
        if(m == 1){
            System.out.println(m+" x "+n+" = "+m*n);
        }else{
            printTable(n, m-1); //recursive call
            System.out.println(m+" x "+n+" = "+m*n);
        }
    }
}
