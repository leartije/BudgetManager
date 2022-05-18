package budget;

import static budget.Categories.*;
import static budget.Main.*;

public class ServiceClass {

    private final BudgetClass budget;

    public ServiceClass() {
        this.budget = new BudgetClass();
    }

    public void startProgram() {
        while (true) {
            Menus.mainMenuMsg();
            String option = scanner.nextLine();
            System.out.println();
            switch (option) {
                case "1":
                    System.out.println("Enter income");
                    double income = scanner.nextDouble();
                    System.out.println("Income was added!\n");
                    scanner.nextLine();
                    budget.setBalance(income);
                    break;
                case "2":
                    purchaseSubmenu();
                    break;
                case "3":
                    showListSubmenu();
                    break;
                case "4":
                    budget.showBalance();
                    break;
                case "0":
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println(option + " is not valid option\n");
                    break;
            }
        }
    }

    private void purchaseSubmenu() {
        boolean back = false;
        while (!back) {
            Menus.purchaseSubmenuMsg();
            String option = scanner.nextLine();
            System.out.println();
            switch (option) {
                case "1":
                    purchase(FOOD);
                    break;
                case "2":
                    purchase(CLOTHES);
                    break;
                case "3":
                    purchase(ENTERTAINMENT);
                    break;
                case "4":
                    purchase(OTHER);
                    break;
                case "5":
                    back = true;
                    startProgram();
                    break;
                default:
                    System.out.println(option + " is not valid option\n");
                    break;
            }
        }
    }

    private void purchase(Categories category) {
        System.out.println("Enter purchase name:");
        String item = scanner.nextLine();
        System.out.println("Enter its price:");
        double price = scanner.nextDouble();
        scanner.nextLine();
        budget.getItemList().add(new Item(item, price, category));
        budget.setBalance(budget.getBalance() - price);
        System.out.println("Purchase was added!\n");
    }

    private void showListSubmenu() {
        boolean back = false;
        while (!back) {
            Menus.showPurchasesMenuMsg();
            String option = scanner.nextLine();
            System.out.println();
            switch (option) {
                case "1":
                    budget.showListOfPurchases(FOOD);
                    break;
                case "2":
                    budget.showListOfPurchases(CLOTHES);
                    break;
                case "3":
                    budget.showListOfPurchases(ENTERTAINMENT);
                    break;
                case "4":
                    budget.showListOfPurchases(OTHER);
                    break;
                case "5":
                    budget.showListOfPurchases(ALL);
                    break;
                case "6":
                    startProgram();
                    back = true;
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
