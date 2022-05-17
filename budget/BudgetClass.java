package budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetClass {

    private final List<Items> itemsList;
    private double balance;

    public BudgetClass() {
        itemsList = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void showBalance() {
        System.out.printf("Balance: $%.2f%n%n", getBalance());
    }

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void showListOfPurchases() {
        if (itemsList.size() == 0) {
            System.out.println("The purchase list is empty\n");
            return;
        }
        itemsList.forEach(System.out::println);
        System.out.printf("Total sum: $%.2f%n%n", getExpenses());
    }

    public double getExpenses() {
        if (itemsList.size() == 0) {
            return 0.0;
        }
        return itemsList.stream()
                .mapToDouble(Items::getItemPrice)
                .sum();
    }
}
