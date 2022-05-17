package budget;

import static budget.Main.*;

public class ServiceClass {

    private BudgetClass budget;

    public ServiceClass() {
        this.budget = new BudgetClass();
    }

    public void startProgram() {
        boolean exit = false;
        while (!exit) {
            Menus.mainMenu();
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
                    System.out.println("Enter purchase name:");
                    String itemName = scanner.nextLine();
                    System.out.println("Enter its price:");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    budget.getItemsList().add(new Items(itemName, price));
                    budget.setBalance(budget.getBalance() - price);
                    System.out.println("Purchase was added!\n");
                    break;
                case "3":
                    budget.showListOfPurchases();
                    break;
                case "4":
                    budget.showBalance();
                    break;
                case "0":
                    exit = true;
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println(option + " is not valid option\n");
                    break;
            }
        }
    }


}
