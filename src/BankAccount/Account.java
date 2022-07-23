package BankAccount;
import java.lang.Math;
abstract class Account {
    protected String accountNumber;
    protected String customerId ;
    protected String branchName = "Periyar Nagar";
    protected String IFSCcode = "IOB7436";
    protected String holderName;
    protected int age;
    protected String dob;
    protected long currentBalance = 0;

    public Account(String holderName, int age, String dob) {
        this.accountNumber = String.valueOf((long)(Math.random()*100000000));
        this.customerId = String.valueOf((long)(Math.random()*50000));
        this.holderName = holderName;
        this.age = age;
        this.dob = dob;
    }

    protected void credit(long amount){
        currentBalance += amount;
        System.out.println("Successfully Deposited "+amount+" to ACC.No : "+IFSCcode+accountNumber);
        System.out.println("Your Current Balance is "+currentBalance+" Rupees");
    }
    protected void debit(long amount){
        if(currentBalance-amount < 0){
            System.out.println("Insufficient balance to make this transaction");
            return;
        }
        System.out.println("Successfully Debited "+amount+" to ACC.No : "+accountNumber);
        currentBalance -= amount;
        System.out.println("Your Current Balance is "+currentBalance+" Rupees");
    }
    protected void showBalance(){
        System.out.println("Your Current Balance is "+currentBalance+" Rupees");
    }

    abstract public void displayAccountDetails();
}
