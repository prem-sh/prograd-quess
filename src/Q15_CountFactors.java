import java.util.Scanner;

public class Q15_CountFactors {
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		System.out.print("Enter an Integer : ");
		int number = input.nextInt();
		System.out.println("You entered ==> "+number);
		System.out.print("Number of factors are : ");
		int count = 0;
		for(int i=1; i<=number; i++) {
		    if(number%i == 0) {
		        count++;
		    }
		}
		System.out.print(count);
	}
}
