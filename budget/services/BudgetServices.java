package budget.services;

import budget.staticandenums.Categories;
import budget.item.Item;

import java.util.ArrayList;
import java.util.List;

import static budget.Main.scanner;
import static budget.staticandenums.MenusAndMsg.*;

public class BudgetServices {
    private final List<Item> itemList;
    private double balance;

    public BudgetServices() {
        itemList = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public void showBalance() {
        System.out.printf(BALANCE_MSG, getBalance());
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void addIncome() {
        System.out.println(ENTER_INCOME_MSG);
        String income = scanner.nextLine();
        if (checkPrice(income)) {
            setBalance(Double.parseDouble(income));
            System.out.println(INCOME_WAS_ADDED);
            return;
        }
        System.out.printf(WRONG_DOUBLE_MSG, income);

    }

    public void purchase(Categories category) {
        System.out.println(ENTER_PURCHASE_MSG);
        String item = scanner.nextLine();
        System.out.println(ENTER_PURCHASE_PRICE_MSG);
        String price = scanner.nextLine();
        if (checkPrice(price)) {
            double priceNum = Double.parseDouble(price);
            getItemList().add(new Item(item, priceNum, category));
            this.balance -= priceNum;
            System.out.println(PURCHASE_ADDED_MSG);
            return;
        }
        System.out.printf(WRONG_DOUBLE_MSG, price);

    }

    public void showListOfPurchases(Categories category) {
        String categoryName = category.name().charAt(0) + category.name()
                .substring(1).toLowerCase();

        if (itemList.size() == 0) {
            System.out.println(EMPTY_PURCHASE_LIST_MSG);
            return;
        }
        if (category.equals(Categories.ALL)) {
            System.out.printf(CATEGORY_NAME_MSG, categoryName);
            getItemList().forEach(System.out::println);
            System.out.printf(TOTAL_SUM_MSG, getExpenses(category));
            return;
        }
        if (getExpenses(category) == 0.0) {
            System.out.println(EMPTY_PURCHASE_LIST_MSG);
            return;
        }
        System.out.printf(CATEGORY_NAME_MSG, categoryName);
        getItemList().stream()
                .filter(item -> item.getCategories().equals(category))
                .forEach(System.out::println);
        System.out.printf(TOTAL_SUM_MSG, getExpenses(category));
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
