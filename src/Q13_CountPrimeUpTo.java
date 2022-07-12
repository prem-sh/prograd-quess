import java.util.Scanner;

public class Q13_CountPrimeUpTo {
	public static void main(String[] args) {
	   Scanner input = new Scanner (System.in);
       int start = 2;
       int count = 0;
       System.out.print ("Enter a number : ");
       int end = input.nextInt ();
       
       for (int i =start; i<= end; i++){
           int number = i;
           boolean flag = false;
           for(int j=2; j <= number/2; j++){
               if(number % j == 0){
                   flag = true;
                   break;
               }
           }
           if(!flag){
                count++;
           }
       }
       System.out.print("There are "+count+" prime numbers between 1 and "+end);

	}
}
