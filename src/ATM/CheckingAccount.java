package ATM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckingAccount extends Account {
    private double checkingBalance = 0;
    Scanner menuInput = new Scanner(System.in);
    boolean end= false;

    SavingsAccount saveacc = new SavingsAccount();
    CheckingAccount checkacc= new CheckingAccount();

    public double getBalance() {
        return checkingBalance;
    }

    @Override
    public double calculateWithdraw(double amount) {
        return 0;
    }

    @Override
    public double calculateDeposit(double amount) {
        return 0;
    }

    @Override
    public void calculateTransfer(double amount) {
        checkingBalance = checkingBalance - amount;
        saveacc.setBalance(saveacc.getBalance() + amount);

    }

    @Override
    public void getWithdrawInput() {

    }

    @Override
    public void getDepositInput() {

    }


    public void setBalance(double amount) {
        this.checkingBalance = amount;

    }

//    boolean end = false;
//
//        try {
//            System.out.println("\nCheckings Account: ");
//            System.out.println(" Type 1 - View Balance");
//            System.out.println(" Type 2 - Withdraw Funds");
//            System.out.println(" Type 3 - Deposit Funds");
//            System.out.println(" Type 4 - Transfer Funds");
//            System.out.println(" Type 5 - Exit");
//            System.out.print("\nChoice: ");
//
//            int selection = menuInput.nextInt();
//
//            switch (selection) {
//                case 1:
//                    System.out.println("\nCheckings Account Balance: " + moneyFormat.format(checkacc.getBalance()));
//                    break;
//                case 2:
//                    checkacc.getWithdrawInput();
//                    break;
//                case 3:
//                    checkacc.getDepositInput();
//                    break;
//
//                case 4:
//                    checkacc.formatBalance("Checkings");
//                    break;
//                case 5:
//                    end = true;
//                    break;
//                default:
//                    System.out.println("\nInvalid Choice.");
//            }
//        } catch (InputMismatchException e) {
//            System.out.println("\nInvalid Choice.");
//            menuInput.next();
//        }


    public void getChecking(Account acc) {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCheckings Account: ");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - Exit");
                System.out.print("\nChoice: ");

                int selection = menuInput.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("\nCheckings Account Balance: " + moneyFormat.format(checkacc.getBalance()));
                        break;
                    case 2:
                        checkacc.getWithdrawInput();
                        break;
                    case 3:
                        checkacc.getDepositInput();
                        break;

                    case 4:
                        checkacc.formatBalance("Checkings");
                        break;
                    case 5:
                        end = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }
    }


    public void formatBalance(String accType) {
        System.out.println("\nSelect an account you wish to tranfers funds to:");
        System.out.println("1. Savings");
        System.out.println("2. Exit");
        System.out.print("\nChoice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
                System.out.print("\nAmount you want to deposit into your Savings Account: ");
                double amount = input.nextDouble();
                if ((saveacc.getBalance() + amount) >= 0 && (checkingBalance - amount) >= 0 && amount >= 0) {
                    saveacc.calculateTransfer(amount);
                    System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(saveacc.getBalance()));
                    System.out.println(
                            "\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
                    end = true;
                } else {
                    System.out.println("\nBalance Cannot Be Negative.");
                }
                break;
            case 2:
                return;
            default:
                System.out.println("\nInvalid Choice.");
                break;
        }


    }
}
