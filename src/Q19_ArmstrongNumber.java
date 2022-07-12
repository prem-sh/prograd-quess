import java.util.Scanner;

//19. JAVA program to check given number is Armstrong or not.
public class Q19_ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number : ");
        int n = input.nextInt();
        int temp = n;
        int sum = 0;
        int len = 0;
        while(temp > 0){
            temp /= 10;
            ++len;
        }
        temp = n;
        while(temp > 0){
            int lastDigit = temp%10;
            sum += Math.pow(lastDigit, len);
            temp /= 10;
        }
        if(sum == n){
            System.out.print(n + " is an Armstrong number");
        }else System.out.print(n + " is not an Armstrong number");
}}
