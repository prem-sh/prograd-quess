/*Mr. Lalwani having Some Currency. 
 * The currency having number as Palidrome gets 3 times more than the currency. 
 * So help out Mr. Lalwani to check which currency going to give him 3 times return. 
 */

import java.util.Scanner;

public class Q7_MrLalwani {
	public static void main(String args[]) {
		int currency = 0, nOfCurrency = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Mr.Lalwani, Could you please tell me the currency you have : ");
		currency = input.nextInt();
		System.out.print("Please mention the number of bank notes you have : ");
		nOfCurrency = input.nextInt();

		int temp = nOfCurrency;
		int reverse = 0;
		int returnAmt = currency;

		while(temp > 0) {
			reverse *= 10;
			reverse += temp%10;
			temp /= 10;
		}
		if(reverse == nOfCurrency) {
			System.out.print("Congrats!, ");
			returnAmt *= 3;
		}
		System.out.print("Your Return amount : "+returnAmt);
		
	}
}
