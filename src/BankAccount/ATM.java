package BankAccount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM implements ATMprops{
    private static Scanner sc = new Scanner(System.in);
    Account acc;
    public ATM() {
        System.out.println("======== MENU ========");
        System.out.println("1) Create new account \n2) Deposit money \n3) Withdraw money \n4) Check Balance \n5) Account Details \n0) Exit");

        while (true){
            System.out.print(" >>--> ");
            int opt = 0;
            try{
                opt = sc.nextInt();
                if(opt>5) throw new IllegalArgumentException("InvalidInput");
            }catch (NumberFormatException e){
                System.out.println("\n\nERROR : Please enter numbers only");
            }catch (IllegalArgumentException e) {
                System.out.println("\n\nERROR : Please Enter numbers between 0 to 5");
            }catch (InputMismatchException e){
                System.out.println("\n\nERROR : Please Enter valid inputs");
            }
            switch (opt){
                case 1:
                    try {
                        createAccount();
                    }catch (InputMismatchException e){
                        System.out.println("\n\nERROR : Age should be a number of years");
                        System.out.println("Cancelling the process ...");
                        return;
                    }
                    break;
                case 2:
                    try{
                        deposit();
                    }catch (InputMismatchException e){
                        System.out.println("\n\nERROR : Amount should be a number");
                        System.out.println("Cancelling the transaction ...");
                        return;
                    }
                    break;
                case 3:
                    try{
                        withDraw();
                    }catch (InputMismatchException e){
                        System.out.println("\n\nERROR : Amount should be a number");
                        System.out.println("Cancelling the transaction ...");
                        return;
                    }
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAccDetails();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public void createAccount() {
        if(acc != null){
            System.out.println("You are not allowed to create another account, Unfortunately this ATM only supports one account");
            return;
        }
        System.out.println("========= Create Bank Account ==========");
        System.out.print("Please enter 1 or 2 \n1 for Current Account and \n2 for Savings Account \n ==> ");
        int type = sc.nextInt();
        System.out.println("Please provide following details");
        switch (type){
            case 1 : {
                sc.nextLine();
                System.out.print("Your Name : ");
                String holderName = sc.nextLine();
                System.out.print("Your Age : ");
                int age = sc.nextInt();
                System.out.print("Your Date of Birth : ");
                String dob = sc.next();
                sc.nextLine();
                System.out.print("Your Company or Organization Name : ");
                String companyName = sc.nextLine();
                acc = new CurrentAccount(holderName, age, dob, companyName);
                acc.displayAccountDetails();
                return;
            }
            case 2: {
                sc.nextLine();
                System.out.print("Your Name : ");
                String holderName = sc.nextLine();
                System.out.print("Your Age : ");
                int age = sc.nextInt();
                System.out.print("Your Date of Birth : ");
                String dob = sc.next();
                System.out.print("Is it a salary account ? (Y/N) ");
                String yesNo = sc.next();
                boolean isSalaryAccount = yesNo.equalsIgnoreCase("Y");
                acc = new SavingsAccount(holderName, age, dob, isSalaryAccount);
                acc.displayAccountDetails();
                return;
            }
            default:
                System.out.println("Invalid input");
                return;
    }
    }

    @Override
    public void deposit() {
        System.out.println("========= Deposit Money ==========");
        if(acc == null){
            System.out.println("No accounts found, Please create an account !");
            return;
        }
        System.out.println("How much you need to Deposit ? ");
        System.out.print("Enter the Amount : ");
        acc.credit(sc.nextInt());
    }

    @Override
    public void withDraw() {
        System.out.println("========= Withdraw Money ==========");
        if(acc == null){
            System.out.println("No accounts found, Please create an account !");
            return;
        }
        System.out.println("How much you need to Withdraw ? ");
        System.out.print("Enter the Amount : ");
        acc.debit(sc.nextInt());
    }

    @Override
    public void checkBalance() {
        if(acc == null){
            System.out.println("No accounts found, Please create an account !");
            return;
        }
        acc.showBalance();
    }

    @Override
    public void displayAccDetails() {
        System.out.println("========= Account Details ==========");
        if(acc == null){
            System.out.println("No accounts found, Please create an account !");
            return;
        }
        acc.displayAccountDetails();
    }
}
