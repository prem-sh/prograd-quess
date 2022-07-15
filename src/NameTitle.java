//Optional Task : Write a program to assign suitable title (Miss, Mrs, Mr) to person.

import java.util.Scanner;

public class NameTitle {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("May i know your name ?  \n --> ");
        String name = sc.nextLine();
        System.out.print("Your Gender ? (M/F) ");
        String gender = sc.next();
        if(gender.equalsIgnoreCase("M")){
            name = "Mr."+name;
        } else if (gender.equalsIgnoreCase("F")) {
            System.out.print("Are you Married ? (Y/N) ");
            String married = sc.next();
            if (married.equalsIgnoreCase("Y")){
                name = "Mrs."+name;
            } else if (married.equalsIgnoreCase("N")) {
                name = "Ms."+name;
            }else {
                System.out.println("Please enter a valid Option");
                System.exit(1);
            }
        }else {
            System.out.println("Please enter a valid Gender");
            System.exit(2);
        }
        System.out.println("\n Welcome , "+name);
    }
}
