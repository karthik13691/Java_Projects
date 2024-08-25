package BankTellerApp;
import java.util.Arrays;
public class TellerApp {
    /*
     a. Account numbers frequently have a fixed length and contain alphanumeric characters.
     b. Balance are declared as a double to accommodate decimal values because double data type has 64 bits
     (15-16 decimal digits) compared to float that has 32 bits(6-9 decimal digits)
    */
    private String[] customerName = {"Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", "Nicole Yoder",
            "Melissa Hoffman", "Beatrice Helman", "Louis Sanders", "Catherine Altman",
            "Ralph Estees", "Samantha Augustine", "Peter Fredricks", "David Alters"};

    private String[] accountNumber = {"123456789012", "234567890123", "345678901234", "456789012345",
            "567890123456", "678901234567", "7890123456"};

    private double[] balance = {7832.45, 2109.87, 15678.22, 341.09, 8942.71, 21563.84, 4875.16, 11237.59, 693.28, 6427.03, 18954.76, 3192.47};

    private final double[] tellerBalance = {2500.0, 2500.0};

    private static final double WITHDRAWAL_AMOUNT = 250.0;
    private static final double DEPOSIT_AMOUNT_1 = 100.0;
    private static final double DEPOSIT_AMOUNT_2 = 475.0;

    String[] teller1Visitors = new String[12];
    String[] teller2Visitors = new String[12];
    private int teller1VisitorsCount = 0;
    private int teller2VisitorsCount = 0;

    // Constructors, getters, and setters

    public double[] getBalances() {
        return balance;
    }
    public String[] getAccountNumber() {
        return accountNumber;
    }
    public String[] getCustomerName() {
        return customerName;
    }

    /* Implement methods for deposits, withdrawals, and checking balance. */

    public void updateTellerBalance(int index, double amount) {
        tellerBalance[index] += amount;
    }

    public void deposit(int index, double amount) {
        balance[index] += amount;
    }

    public void withdraw(int index, double amount) {
        balance[index] -= amount;
    }

    private void addVisitor(int tellerIndex, String visitor) {
        if (tellerIndex == 0) {
            teller1Visitors[teller1VisitorsCount++] = visitor;
        } else {
            teller2Visitors[teller2VisitorsCount++] = visitor;
        }
    }


    // Start main method
    public TellerApp() {

        System.out.println("Starting Balance: " + Arrays.toString(balance));

        // Perform transactions
        for (int i=0; i<customerName.length; i++) {
            int counter = i + 1;
            if (counter % 3 == 0) {
                withdraw(i, WITHDRAWAL_AMOUNT);
                updateTellerBalance(counter%2, -WITHDRAWAL_AMOUNT);
                addVisitor(counter%2, customerName[i]);
            }
            else if (counter % 5 == 0) {
                deposit(i, DEPOSIT_AMOUNT_2);
                updateTellerBalance(counter % 2, DEPOSIT_AMOUNT_2);
                addVisitor(counter % 2, customerName[i]);
            }
            else {
                deposit(i, DEPOSIT_AMOUNT_1);
                updateTellerBalance(counter % 2, DEPOSIT_AMOUNT_1);
                addVisitor(counter % 2, customerName[i]);
            }
        }

        // Print output
        System.out.println("\nTeller 1's drawer balance is: $" + tellerBalance[0]);
        System.out.println("Teller 1's visitors are: "  + Arrays.toString(Arrays.copyOfRange(teller1Visitors, 0, teller1VisitorsCount)));

        System.out.println("\nTeller 2's drawer balance is: $" + tellerBalance[1]);
        System.out.println("Teller 2's visitors are: " + Arrays.toString(Arrays.copyOfRange(teller2Visitors, 0, teller2VisitorsCount)));

        System.out.println("\nClosing Balance: " + Arrays.toString(balance));
    }
    public static void main(String[] args) {
        new TellerApp();
    }
}

