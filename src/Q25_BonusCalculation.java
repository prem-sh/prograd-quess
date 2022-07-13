//Write a Java program for bonus calculation.
//Accept basic salary from user.
//Calculate TA = 10%, DA= 15%,HRA = 20%, PF= 12% of basic salary.
//If basic >= 20,000 then give 10% bonus otherwise give 20% bonus on basic salary.
//Calculate his gross (final) salary ( gross salary = Basic + DA + TA + HRA + Bonus – PF)

import java.util.Scanner;

public class Q25_BonusCalculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("==== Salary calculator ====\n");
        System.out.print("Input Basic salary : ");
        double baseSalary = input.nextDouble();
        double ta = baseSalary*10/100;
        double da = baseSalary*15/100;
        double hra = baseSalary*20/100;
        double pf = baseSalary*12/100;
        int bonus;
        if(baseSalary >= 20000){
            bonus = 10;
        }else {
            bonus = 20;
        }

        double bonusAmount = baseSalary*bonus/100;
        {
            System.out.println();
            System.out.println("Basic ---------- " + baseSalary);
            System.out.println("DA    ---------- " + da);
            System.out.println("TA    ---------- " + ta);
            System.out.println("HRA   ---------- " + hra);
            System.out.println("Bonus ---------- " + bonusAmount + " (" + bonus + "%) of Basic");
            System.out.println("PF    ---------- " + pf);
        }
        double grossSalary = baseSalary+da+ta+hra+bonusAmount-pf;

        System.out.println("\n=== Gross salary : "+grossSalary+" ===");
    }
}
