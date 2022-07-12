import java.util.Scanner;

public class Q14_PrintFactors {
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		System.out.print("Enter an Integer : ");
		int number = input.nextInt();
		System.out.println("You entered ==> "+number);
		System.out.print("The factors of "+number+" are : ");
		for(int i=1; i<=number; i++) {
		    if(number%i == 0) {
		        System.out.print(i+" ");
		    }
		}
	}
}
