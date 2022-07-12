import java.util.Scanner;

public class Q16_PrimeFactorTree {
  public static void main (String[]args)
  {
      Scanner input = new Scanner (System.in);
      System.out.print ("Enter an Integer : ");
      int number = input.nextInt ();
      System.out.println ("You entered ==> " + number);
      System.out.print ("Prime factors are : ");
      int fact = 2;
      int temp = number;
      
      while(temp != 1){
          if(temp%fact == 0) {
		        if(isPrime(fact)){
		            System.out.print(" "+fact);
		            temp/=fact;
		        }
		    }else{fact++;}
      }
  }

  public static boolean isPrime (int n)
  {
    boolean flag = false;
    for (int i = 2; i <= n/2; i++)
      {
	      if (n % i == 0)
    	  {
	    	  flag = true;
    	      break;
    	  }
      }

    if (!flag)
      return true;
    else
      return false;
  }
}
