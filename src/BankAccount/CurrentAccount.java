package BankAccount;

public class CurrentAccount extends Account{
    private final long minimumBalance = 10000;
    private String companyName;

    public CurrentAccount(String holderName, int age, String dob, String companyName) {
        super(holderName, age, dob);
        this.companyName = companyName;
    }

    @Override
    public void displayAccountDetails() {
        {
            System.out.println("======== Current Account Details ========");
            System.out.println("Company/Organization     : "+companyName);
            System.out.println("Account Holder Name      : "+holderName);
            System.out.println("Customer ID              : "+customerId);
            System.out.println("Account Number           : "+accountNumber);
            System.out.println("Branch Name              : "+branchName);
            System.out.println("IFSC                     : "+IFSCcode);
            System.out.println("Account Holder Age       : "+age);
            System.out.println("Account Holder DOB       : "+dob);
            System.out.println("Minimum Balance required : "+minimumBalance);
            System.out.println("Transaction Limit        : unlimited/day");
            System.out.println("CURRENT Balance          : *** "+currentBalance+" ***");
        }
    }
}
