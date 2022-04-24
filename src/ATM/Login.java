package ATM;

import java.util.*;

public class Login {

    Scanner menuInput = new Scanner(System.in);
    HashMap<Integer, Account> data = new HashMap<Integer, Account>();
    OptionMenu om= new OptionMenu();

    public void getLogin(){
        boolean end = false;
        int customerNumber = 0;
        int pinNumber = 0;
        while (!end) {
            try {
                System.out.print("\nEnter your customer number: ");
                customerNumber = menuInput.nextInt();
                System.out.print("\nEnter your PIN number: ");
                pinNumber = menuInput.nextInt();
                Iterator it = data.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    Account acc = (Account) pair.getValue();
                    if (data.containsKey(customerNumber) && pinNumber == acc.getPinNumber()) {
                        om.getAccountType();
                        end = true;
                        break;
                    }
                }
                if (!end) {
                    System.out.println("\nWrong Customer Number or Pin Number");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Character(s). Only Numbers.");
            }
        }

    }
}
