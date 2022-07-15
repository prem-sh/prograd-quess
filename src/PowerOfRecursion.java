//Optional Task : Find the power of given number using recursion(take input as base and exponent)
import java.util.Scanner;
public class PowerOfRecursion {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter Number and Power : ");
        int n = sc.nextInt();
        int pow = sc.nextInt();
        if(pow < -1) {
            System.out.println("Please enter number more than 0");
            System.exit(1);
        }
        long result = power(n, pow);
        System.out.println(n+" to the power of "+pow+" is "+result);
    }

    static long power(int n, int pow){
        if(pow == 1) return n;
        else return (n * power(n, pow-1));
    }
}
