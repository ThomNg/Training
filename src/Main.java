import de.rhistel.logic.ConsoleReader;

public class Main {
    //region 0. CONST
    private final static String WELCOME_VENDING = "Welcome to Vending Maschine!";
    private final static String PAYMENT_BIGGER_DRINK_PRICE = "Here is your drink and thank you for purchasing, this is your return money %2.2f Euro %n";
    private final static String PAYMENT_EQUAL_DRINK_PRICE = "Here is your drink, have a nice day!";
    private final static String PAYMENT_INSUFFICIENT_PRICE = "Returning %2.2f Euro, to purchase your desire drink. You need to enter %2.2f Euro more";
    private final static String USER_SELECTION_MASK = "Please select your drink by choosing 1, 2, 3 or 4? ";
    private final static String PAYMENT_MASK = "Please enter your payment here: ";
    private final static String MACHINE_DRINK_INFO = "Price for your chosen drink %s is 2.0 Euro %n";
    //endregion

    //region 1. Main
    public static void main(String[] args) {
        startApplication();
    }
    //endregion

    //region 2. StartApplication
    private static void startApplication() {
        printApplicationName();
        vendingMachineStarting();
    }

    private static void printApplicationName() {
        System.out.println(WELCOME_VENDING);
    }
    //endregion

    //region 3. Vending Machine start
    private static void vendingMachineStarting() {
        double drinkPrice = 2.0;
        String[] drinkList = {"Cola","Fanta","Mezzo-Mix","Sprudel"};

        printDrinksAvailable(drinkList);

        System.out.println(USER_SELECTION_MASK);
        int userChooseDrink = ConsoleReader.in.readPositivInt();

        if (userChooseDrink < 4) {
            System.out.printf(MACHINE_DRINK_INFO, drinkList[userChooseDrink-1]);
            System.out.println(PAYMENT_MASK);

            double userPayment = ConsoleReader.in.readDouble();
            priceCalculationAndDrinkOutput(userPayment, drinkPrice);
        }else{
            vendingMachineStarting();
        }
    }

    private static void priceCalculationAndDrinkOutput(double userPayment, double drinkPrice) {
        if(userPayment > drinkPrice){
            System.out.printf(PAYMENT_BIGGER_DRINK_PRICE, userPayment - drinkPrice);
        }else if(userPayment == drinkPrice){
            System.out.println(PAYMENT_EQUAL_DRINK_PRICE);
        }else{
            System.out.printf(PAYMENT_INSUFFICIENT_PRICE, userPayment, drinkPrice - userPayment);
        }
    }

    private static void printDrinksAvailable(String[] drinks) {
        for (int i = 0; i < drinks.length; i++) {
            System.out.println(i+1 + ". " + drinks[i]);
        }
    }
    //endregion
}