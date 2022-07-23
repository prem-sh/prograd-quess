package BankAccount;

public class SavingsAccount extends Account {
    private final int ROI = 7;
    private final long minimumBalance = 1000;
    private final int transactionLimits = 100;
    private boolean isSalaryAccount;

    public SavingsAccount(String holderName, int age, String dob, boolean isSalaryAccount) {
        super(holderName, age, dob);
        this.isSalaryAccount = isSalaryAccount;
    }

    @Override
    public void displayAccountDetails() {
        {
            System.out.println("======== Savings Account Details ========");
            System.out.println("Account Holder Name      : "+holderName);
            System.out.println("Customer ID              : "+customerId);
            System.out.println("Account Number           : "+accountNumber);
            System.out.println("Branch Name              : "+branchName);
            System.out.println("IFSC                     : "+IFSCcode);
            System.out.println("Account Holder Age       : "+age);
            System.out.println("Account Holder DOB       : "+dob);
            System.out.println("Salary account           : "+isSalaryAccount);
            System.out.println("ROI                      : "+ROI);
            System.out.println("Minimum Balance required : "+minimumBalance);
            System.out.println("Transaction Limit        : "+transactionLimits+" transactions/day");
            System.out.println("CURRENT Balance          : *** "+currentBalance+" ***");
        }
    }
}
