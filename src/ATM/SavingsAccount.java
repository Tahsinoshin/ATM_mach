package ATM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SavingsAccount extends Account {
    Scanner menuInput = new Scanner(System.in);

    private double savingBalance = 0;
    boolean end = false;

    CheckingAccount checkAcc = new CheckingAccount();

    public void setBalance(double amount) {
        this.savingBalance = amount;
    }

    public double getBalance() {
        return savingBalance;
    }

    @Override
    public double calculateWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    @Override
    public double calculateDeposit(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    @Override
    public void calculateTransfer(double amount) {
        savingBalance = savingBalance - amount;
        checkAcc.setBalance(checkAcc.getBalance() + amount);

    }

    @Override
    public void getWithdrawInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
                System.out.print("\nAmount you want to withdraw from Savings Account: ");
                double amount = input.nextDouble();
                if ((savingBalance - amount) >= 0 && amount >= 0) {
                    calculateWithdraw(amount);
                    System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
                    end = true;
                } else {
                    System.out.println("\nBalance Cannot Be Negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }

    }

    @Override
    public void getDepositInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
                System.out.print("\nAmount you want to deposit into your Savings Account: ");
                double amount = input.nextDouble();

                if ((savingBalance + amount) >= 0 && amount >= 0) {
                    calculateDeposit(amount);
                    System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
                    end = true;
                } else {
                    System.out.println("\nBalance Cannot Be Negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }

    }


    public void getSaving() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nSavings Account: ");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - Exit");
                System.out.print("Choice: ");
                int selection = menuInput.nextInt();
                switch (selection) {
                    case 1:
                        System.out.println("\nSavings Account Balance: " + moneyFormat.format(getBalance()));
                        break;
                    case 2:
                        getWithdrawInput();
                        break;
                    case 3:
                        getDepositInput();
                        break;
                    case 4:
                        formatBalance("Savings");
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

        System.out.println("\nSelect an account you wish to tranfers funds to: ");
        System.out.println("1. Checkings");
        System.out.println("2. Exit");
        System.out.print("\nChoice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
                System.out.print("\nAmount you want to deposit into your savings account: ");
                double amount = input.nextDouble();
                if ((checkAcc.getBalance() + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
                    checkAcc.calculateTransfer(amount);
                    System.out.println("\nCurrent checkings account balance: " + moneyFormat.format(checkAcc.getBalance()));
                    System.out.println("\nCurrent savings account balance: " + moneyFormat.format(savingBalance));
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



