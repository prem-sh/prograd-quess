//Take input one’s gender and material status if required.

import java.util.Scanner;

public class PerfectNumberRange {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Please enter start and end numbers : ");
        int i = sc.nextInt();
        int j = sc.nextInt();
        if(i > j){
            i = i+j;
            j = i-j;
            i= i - j;
        }
        for (;i<=j;i++){
            if(isPerfect(i)) System.out.println(i+" ");
        }
    }

    static Boolean isPerfect(int n){
        int sum = 0;
        for(int i = 1; i<n; i++)
            if(n%i == 0) sum+=i;
        if(sum == n) return true;
        return false;
    }
}
