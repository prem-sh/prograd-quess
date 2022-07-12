
/* Given a string of digits, 
* you should replace any digit below 5 with '0' and any digit 5 and above with '1'. 
* Return the resulting string. Note: input will never be an empty string */
import java.util.Scanner;
public class Q6_StringReplace1 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String inputString = "";
		String outputString = "";
		boolean flag = false;
		MAINLOOP : do {
			flag = false;
			outputString = "";
			System.out.print("Please input digits: ");
			inputString = input.nextLine();
			if(inputString.length() < 1) {
				System.out.print("No Inputs Provided, Try Again\n\n");
				flag = true;
			}
			else {
				for(char i : inputString.toCharArray()) {
					if(!(i >= '0' && i <= '9')) {
						System.out.print("Invalid input, Try Again\n\n");
						flag = true;
						continue MAINLOOP;
					}
					if((int)(i - '0') < 5) outputString+='0';
					else outputString+='1';
				}
			}
		}while(flag); 
		System.out.print("Output : " + outputString);
	}
}
