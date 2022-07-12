import java.util.Scanner;

public class Q12_PrimeBetween {
	public static void main(String[] args) {
	   Scanner input = new Scanner (System.in);
       System.out.print ("Enter start number : ");
       int start = input.nextInt ();
       System.out.print ("Enter end number : ");
       int end = input.nextInt ();
       System.out.print("Prime numbers between "+start+" to "+end+" are ");
       for (int i = start; i<= end; i++){
           if(i == 1) continue;
           int number = i;
           boolean flag = false;
           for(int j=2; j <= number/2; j++){
               if(number % j == 0){
                   flag = true;
                   break;
               }
           }
           if(!flag){
                System.out.print(number+" ");   
           }
       }

	}
}
