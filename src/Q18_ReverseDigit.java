import java.util.Scanner;
//18. JAVA program to reverse the given number.

public class Q18_ReverseDigit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number : ");
        int n = input.nextInt();
        int temp = n;
        int reverse = 0;
        while(n>0){
            reverse *= 10;
            reverse += n%10;
            n /= 10;
        };
        System.out.print("Reverse of "+temp+" is "+reverse);
    }
}
