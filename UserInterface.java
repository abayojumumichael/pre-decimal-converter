/**
 * Provides a command-line interface for converting and displaying British currency values.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private Scanner reader = new Scanner(System.in);
    
    /**
     * Runs the user interface, handling user input and output.
     */
    public void run() {
        try {
            System.out.println("What would you like to do?");
            System.out.println("1. Pretty print pre-decimal currency.");
            System.out.println("2. Convert new pennies to pre-decimal currency.");

            int option;
            try {
                option = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number for the option.");
                return;
            }

            switch (option) {
                case 1:
                    int pounds = 0, shillings = 0, pence = 0;
                    try {
                        System.out.println("Enter the number of pounds");
                        pounds = reader.nextInt();
                        System.out.println("Enter the number of shillings");
                        shillings = reader.nextInt();
                        System.out.println("Enter the number of pence");
                        pence = reader.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter integer values for pounds, shillings, and pence.");
                        reader.nextLine();
                        return;
                    }

                    Boolean isValidNN = checkNonNegative(pounds, shillings, pence);
                    if (!isValidNN) {
                        return;
                    }
                    Boolean isValidGTZ = checkGreaterThanZero(pounds, shillings, pence);
                    if (!isValidGTZ) {
                        return;
                    }
                    PreDecimalCurrency pdc = new PreDecimalCurrency(pounds, shillings, pence);
                    System.out.println(pdc.toString());
                    break;
                case 2:
                    int newPennies = 0;
                    try {
                        System.out.println("Enter the number of new pennies");
                        newPennies = reader.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter an integer value for new pennies.");
                        reader.nextLine();
                        return;
                    }
                    if (newPennies < 0) {
                        System.out.println("Invalid value. Must be positive integer.");
                        return;
                    }
                    DecimalCurrency dc = new DecimalCurrency(newPennies);
                    pdc = dc.toPreDecimal();
                    System.out.printf("%dp in pre-decimal currency is %s\n", newPennies, pdc.toString());
                    break;
                default:
                    System.out.println("Invalid choice. Goodbye.");
                    return;
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } 
    }
    
    /**
     * Checks if all input values are non-negative.
     * @param pounds the number of pounds
     * @param shillings the number of shillings
     * @param pence the number of pence
     * @return true if all values are non-negative, false otherwise
     */
    public Boolean checkNonNegative(int pounds, int shillings, int pence) {
        Boolean isValid = true;
        int[] valuesList = {pounds, shillings, pence};
        for (int i = 0; i < 3; i++) {
            if (valuesList[i] < 0) {
                System.out.println("Invalid values. All must be non-negative integers.");
                isValid = false;
                break;
            } 
        }
        return isValid;
    }

    /**
     * Checks if at least one input value is greater than zero.
     * @param pounds the number of pounds
     * @param shillings the number of shillings
     * @param pence the number of pence
     * @return true if at least one value is greater than zero, false otherwise
     */
    public Boolean checkGreaterThanZero(int pounds, int shillings, int pence) {
        int total = 0;
        Boolean isValid = true;
        int[] valuesList = {pounds, shillings, pence};
        for (int i = 0; i < 3; i++) {
            total += valuesList[i];
        }
        if (total == 0) {
            System.out.println("Invalid values. At least one must be greater than 0.");
            isValid = false;
        }
        return isValid;
    }       
}
