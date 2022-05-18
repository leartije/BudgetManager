package budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetClass {

    private final List<Item> itemList;
    private double balance;


    public BudgetClass() {
        itemList = new ArrayList<>();
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

    public List<Item> getItemList() {
        return itemList;
    }

    public void showListOfPurchases(Categories category) {
        if (itemList.size() == 0) {
            System.out.println("The purchase list is empty\n");
            return;
        } else if (category.equals(Categories.ALL)) {
            System.out.println("All:");
            getItemList().forEach(System.out::println);
            System.out.printf("Total sum: $%.2f%n%n", getExpenses(category));
            return;
        }
        System.out.println(category.name().charAt(0) +
                category.name().substring(1).toLowerCase() + ":");

        getItemList().stream()
                .filter(item -> item.getCategories().equals(category))
                .forEach(System.out::println);
        System.out.printf("Total sum: $%.2f%n%n", getExpenses(category));
    }

    public double getExpenses(Categories category) {
        if (getItemList().size() == 0) {
            return 0.0;
        } else if (category.equals(Categories.ALL)) {
            return getItemList().stream().mapToDouble(Item::getItemPrice).sum();
        }
        return getItemList().stream()
                .filter(item -> item.getCategories().equals(category))
                .mapToDouble(Item::getItemPrice)
                .sum();
    }
}
