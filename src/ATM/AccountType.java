package ATM;



public class AccountType {

    private static Account account;
    public static SavingsAccount saveacc;
    public static CheckingAccount checkacc;

    AccountType() {

        saveacc = new SavingsAccount();
        checkacc = new CheckingAccount();
    }

    public void setSavingsAcc() {
        account  = saveacc;
    }
    public void setCheckingAcc(){
        account = checkacc;
    }
    public Account getSavingsAcc(){
        return this.saveacc;
    }
    public Account getCheckingAcc(){
        return this.checkacc;
    }





}
