package ATM;

import java.text.DecimalFormat;
import java.util.Scanner;

public abstract class Account {

        // variables
        private int customerNumber;
        private int pinNumber;



        Scanner input = new Scanner(System.in);
        DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

        public Account() {
        }

        public Account(int customerNumber, int pinNumber) {
            this.customerNumber = customerNumber;
            this.pinNumber = pinNumber;
        }


        public int setCustomerNumber(int customerNumber) {
            this.customerNumber = customerNumber;
            return customerNumber;
        }

        public int getCustomerNumber() {
            return customerNumber;
        }

        public int setPinNumber(int pinNumber) {
            this.pinNumber = pinNumber;
            return pinNumber;
        }

        public int getPinNumber() {
            return pinNumber;
        }

        public abstract double getBalance();

        public abstract double calculateWithdraw(double amount);

        public abstract double calculateDeposit(double amount);

        public abstract void calculateTransfer(double amount);

        public abstract void getWithdrawInput();

        public abstract void getDepositInput();

    public abstract void formatBalance(String savings);

//        public  void getTransferInput(){
//
//        }

//    public void getTransferInput(String accType) {
//        boolean end = false;
//        while (!end) {
//            try {
//                if (accType.equals("Checkings")) {
//                    System.out.println("\nSelect an account you wish to tranfers funds to:");
//                    System.out.println("1. Savings");
//                    System.out.println("2. Exit");
//                    System.out.print("\nChoice: ");
//                    int choice = input.nextInt();
//                    switch (choice) {
//                        case 1:
//                            System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
//                            System.out.print("\nAmount you want to deposit into your Savings Account: ");
//                            double amount = input.nextDouble();
//                            if ((savingBalance + amount) >= 0 && (checkingBalance - amount) >= 0 && amount >= 0) {
//                                calcCheckTransfer(amount);
//                                System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
//                                System.out.println(
//                                        "\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
//                                end = true;
//                            } else {
//                                System.out.println("\nBalance Cannot Be Negative.");
//                            }
//                            break;
//                        case 2:
//                            return;
//                        default:
//                            System.out.println("\nInvalid Choice.");
//                            break;
//                    }
//                } else if (accType.equals("Savings")) {
//                    System.out.println("\nSelect an account you wish to tranfers funds to: ");
//                    System.out.println("1. Checkings");
//                    System.out.println("2. Exit");
//                    System.out.print("\nChoice: ");
//                    int choice = input.nextInt();
//                    switch (choice) {
//                        case 1:
//                            System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
//                            System.out.print("\nAmount you want to deposit into your savings account: ");
//                            double amount = input.nextDouble();
//                            if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
//                                calcSavingTransfer(amount);
//                                System.out.println("\nCurrent checkings account balance: " + moneyFormat.format(checkingBalance));
//                                System.out.println("\nCurrent savings account balance: " + moneyFormat.format(savingBalance));
//                                end = true;
//                            } else {
//                                System.out.println("\nBalance Cannot Be Negative.");
//                            }
//                            break;
//                        case 2:
//                            return;
//                        default:
//                            System.out.println("\nInvalid Choice.");
//                            break;
//                    }
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("\nInvalid Choice.");
//                input.next();
//            }
//        }
//    }
    }
