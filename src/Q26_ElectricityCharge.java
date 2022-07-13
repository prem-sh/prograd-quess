//Write a program to input electricity unit charge and calculate the total electricity bill according to the given condition:
//For first 50 units Rs. 0.50/unit
//For next 100 units Rs. 0.75/unit
//For next 100 units Rs. 1.20/unit
//For unit above 250 Rs. 1.50/unit
//An additional surcharge of 20% is added to the bill.

import java.util.Scanner;
public class Q26_ElectricityCharge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many units : ");
        int units = input.nextInt();
        double charge = 0;
        for (int unit=1; unit<=units; unit++){
            if (unit <= 50){
                charge += 0.5;
            } else if (unit<=150) {
                charge += 0.75;
            } else if (unit<=250) {
                charge += 1.2;
            }else{
                charge += 1.5;
            }
        }
        charge += charge*20/100; //surcharge 20%
        System.out.println("Total Electricity charge for "+units+" Units : "+charge);
    }
}
