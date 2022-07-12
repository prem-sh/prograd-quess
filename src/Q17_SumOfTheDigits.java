import java.util.Scanner;

//17. 6. JAVA program to print sum of digits. (eg. 512 = 8)

public class Q17_SumOfTheDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter a number : ");
        int n = input.nextInt();
        int sum = 0;
        while(n > 0) {
            sum+= n%10;
            n/=10;
        }
        System.out.print("Sum of digits : "+sum);
    }
}
