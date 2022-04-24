package ATM;

import java.io.IOException;
import java.util.*;

public class CreateAccount {

    Scanner menuInput = new Scanner(System.in);
    HashMap<Integer, Account> data = new HashMap<Integer, Account>();
    Login lg= new Login();
    public void createAccount() throws IOException {
        int cst_no = 0;
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nEnter your customer number ");
                cst_no = menuInput.nextInt();
                Iterator it = data.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    if (!data.containsKey(cst_no)) {
                        end = true;
                    }
                }
                if (!end) {
                    System.out.println("\nThis customer number is already registered");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }
        System.out.println("\nEnter PIN to be registered");
        int pin = menuInput.nextInt();
        // data.put(cst_no, new Account());
        System.out.println("\nYour new account has been successfuly registered!");
        System.out.println("\nRedirecting to login.............");
        lg.getLogin();
    }

}
