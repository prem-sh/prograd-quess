package inheritance.car;

import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //get inheritance.car.Car
        Car car1 = new Car();
        System.out.println("==== Enter CAR details ====");
        System.out.print("Enter car name : ");
        car1.setCarName(sc.nextLine());
        System.out.print("Enter car manufacturer : ");
        car1.setManufacturer(sc.nextLine());
        System.out.print("Enter car maximum speed : ");
        car1.setMaxSpeed(sc.nextInt());
        System.out.print("Fuel : ");
        sc.nextLine();
        car1.setFuel(sc.nextLine());
        System.out.print("Enter No.of Wheels : ");
        car1.setNumberOfWheels(sc.nextInt());
        System.out.println();


        //get Sports inheritance.car.Car
        SportsCar car2 = new SportsCar();
        System.out.println("==== Enter SPORTS CAR details ====");
        System.out.println();
        System.out.print("Enter sports car name : ");
        sc.nextLine();
        car2.setCarName(sc.nextLine());
        System.out.print("Enter sports car manufacturer : ");
        car2.setManufacturer(sc.nextLine());
        System.out.print("Enter sports car maximum speed : ");
        car2.setMaxSpeed(sc.nextInt());
        System.out.print("Your Sports car has Rocket boosters? (Y/N) ");
        char yesNo = sc.next().charAt(0);
        if(yesNo == 'Y' ||yesNo == 'y') car2.setHasRocketBooster(true);
        else if(yesNo == 'N' ||yesNo == 'n') car2.setHasRocketBooster(false);
        else {
            System.out.println("That is invalid answer, it's ok we'll take it as NO");
            car2.setHasRocketBooster(false);
        }
        System.out.print("Fuel : ");
        sc.nextLine();
        car2.setFuel(sc.nextLine());
        System.out.print("Enter No.of Wheels : ");
        car2.setNumberOfWheels(sc.nextInt());


        System.out.println();
        System.out.println("====== CAR DETAILS =======");
        System.out.println("inheritance.car.Car name : "+car1.getCarName());
        System.out.println("Manufacturer : "+car1.getManufacturer());
        System.out.println("Top speed : "+car1.getMaxSpeed());
        System.out.println("Fuel : "+car1.getFuel());
        System.out.println("No.Of wheels : "+car1.getNumberOfWheels());

        System.out.println();
        System.out.println("=== SPORTS CAR DETAILS ===");
        System.out.println("Sports car Name : "+car2.getCarName());
        System.out.println("Manufacturer : "+car2.getManufacturer());
        System.out.println("Top speed : "+car2.getMaxSpeed());
        System.out.println("Has Rocket booster : "+car2.isHasRocketBooster());
        System.out.println("Fuel : "+car2.getFuel());
        System.out.println("No.Of wheels : "+car2.getNumberOfWheels());
    }
}


