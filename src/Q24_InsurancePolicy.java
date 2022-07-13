//If driver is married
//If driver is unmarried male and age above 30
//f driver is unmarried female and age above 25
import java.util.Scanner;

public class Q24_InsurancePolicy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("\n================ Insurance Eligibility Checker ====================");
            System.out.print("\nAre you MARRIED ? (yes/no) ");
            String temp = input.next();
            if(!(temp.equalsIgnoreCase("yes") || temp.equalsIgnoreCase("no"))) {
                System.out.println("Invalid Input: Please Try Again\n\n");
            };
            boolean isMarried = temp.equalsIgnoreCase("yes");
            if(isMarried){
                System.out.println("\n=== Congrats !, You are eligible for Insurance ===");
                break;
            }else {
                System.out.print("\nChoose your Gender  ? (M/F) ");
                String gender = input.next();

                if(gender.equalsIgnoreCase("M")){
                    System.out.print("\nYour age ? ");
                    int age = input.nextInt();

                    if(age > 30){
                        System.out.println("\n=== Congrats !, You are eligible for Insurance ===");
                        break;
                    }else {
                        System.out.println("\nXXX Sorry, You are NOT eligible for Insurance XXX");
                        break;
                    }
                } else if (gender.equalsIgnoreCase("F")) {
                    System.out.print("\nYour age ? ");
                    int age = input.nextInt();

                    if(age > 25){
                        System.out.println("\n=== Congrats !, You are eligible for Insurance ===");
                        break;
                    }else {
                        System.out.println("\nXXX Sorry, You are NOT eligible for Insurance XXX");
                        break;
                    }
                }else {
                    System.out.println("Invalid Input: Please Try Again\n\n");
                }
            }
        }
    }
}
