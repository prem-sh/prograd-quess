//20. JAVA Program to Display Armstrong Number between Two Intervals.

import java.util.Scanner;

public class Q20_ArmstrongRange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please start number : ");
        int start = input.nextInt();
        System.out.print("Please end number : ");
        int end = input.nextInt();
        System.out.print("Armstong numbers between " + start + " and " + end + " are :");
        for (int i = start; i <= end; i++) if (checkArmstrong(i)) System.out.print(" " + i);
    }

    static boolean checkArmstrong(int n) {
        int temp = n, sum = 0, len = 0;
        while (temp > 0) {
            temp /= 10;
            ++len;
        }
        temp = n;
        while (temp > 0) {
            int lastDigit = temp % 10;
            sum += Math.pow(lastDigit, len);
            temp /= 10;
        }
        if (sum == n) return true;
        return false;
    }
}