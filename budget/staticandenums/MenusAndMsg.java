package budget.staticandenums;

public class MenusAndMsg {

    public static final String SAVE_MSG = "Purchases were saved!\n";
    public static final String LOAD_MSG = "Purchases were loaded!\n";
    public static final String WRONG_INPUT_MSG = "\"%s\" is not walid input%n%n";
    public static final String ERROR_MSG = "Something is wrong\n";
    public static final String TOTAL_SUM_MSG = "Total sum: $%.2f%n%n";
    public static final String BALANCE_MSG = "Balance: $%.2f%n%n";
    public static final String CATEGORY_NAME_MSG = "%s:%n";
    public static final String EMPTY_PURCHASE_LIST_MSG = "The purchase list is empty\n";
    public static final String ENTER_PURCHASE_MSG = "Enter purchase name:";
    public static final String ENTER_PURCHASE_PRICE_MSG = "Enter its price:";
    public static final String PURCHASE_ADDED_MSG = "Purchase was added!\n";
    public static final String ENTER_INCOME_MSG = "Enter income:";
    public static final String INCOME_WAS_ADDED = "Income was added!\n";
    public static final String TYPES_ANALYZE_MSG = "Types:%n" +
            "Food - $%.2f%n" +
            "Entertainment - $%.2f%n" +
            "Clothes - $%.2f%n" +
            "Other - $%.2f%n" +
            "Total sum: $%.2f%n%n";
    public static final String BYE_MSG = "Bye!";
    public static final String FILE_NAME = "purchases.txt";
    public static final String WRONG_DOUBLE_MSG = "\"%s\" is not walid input%n%n";

    public static void mainMenuMsg() {
        System.out.println("Choose your action:\n" +
                "1) Add income\n" +
                "2) Add purchase\n" +
                "3) Show list of purchases\n" +
                "4) Balance\n" +
                "5) Save\n" +
                "6) Load\n" +
                "7) Analyze (Sort)\n" +
                "0) Exit");
    }

    public static void purchaseSubmenuMsg() {
        System.out.println("Choose the type of purchase\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other\n" +
                "5) Back");
    }

    public static void showPurchasesMenuMsg() {
        System.out.println("Choose the type of purchases\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other\n" +
                "5) All\n" +
                "6) Back");
    }

    public static void analyseSubmenuMsg() {
        System.out.println("How do you want to sort?\n" +
                "1) Sort all purchases\n" +
                "2) Sort by type\n" +
                "3) Sort certain type\n" +
                "4) Back");
    }

    public static void sortByTypeSubmenuMsg() {
        System.out.println("Choose the type of purchase\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other");
    }

    public static boolean checkPrice(String price) {
        try {
            double d = Double.parseDouble(price);
            if (d > 0) {
                return true;
            }
            throw new NumberFormatException();
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
