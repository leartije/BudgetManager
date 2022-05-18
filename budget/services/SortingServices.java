package budget.services;

import budget.staticandenums.Categories;

import java.util.Collections;

import static budget.staticandenums.Categories.*;
import static budget.staticandenums.MenusAndMsg.*;
public class SortingServices {
    private final BudgetServices budget;
    private double food;
    private double entertainment;
    private double clothes;
    private double other;
    private double all;

    public SortingServices(BudgetServices budget) {
        this.budget = budget;
    }

    public void sortAll() {
        if (budget.getItemList().size() == 0) {
            System.out.println(EMPTY_PURCHASE_LIST_MSG);
            return;
        }
        Collections.sort(budget.getItemList());
        System.out.println("All:");
        budget.getItemList().forEach(System.out::println);
        System.out.printf(TOTAL_SUM_MSG, budget.getExpenses(ALL));
    }

    public void sortByCertainType() {
        setTypes();
        System.out.printf(
                TYPES_ANALYZE_MSG,
                food, entertainment,
                clothes,
                other,
                all
        );
    }

    public void sortByCertainType(Categories category) {
        double expenses = budget.getExpenses(category);
        if (expenses == 0.0) {
            System.out.println(EMPTY_PURCHASE_LIST_MSG);
            return;
        }
        Collections.sort(budget.getItemList());
        String categoryName = category.name().charAt(0) + category.name().substring(1).toLowerCase();
        System.out.println(categoryName);
        budget.getItemList()
                .stream()
                .filter(item -> item.getCategories().equals(category))
                .forEach(System.out::println);
        System.out.printf(TOTAL_SUM_MSG, expenses);
    }

    private void setTypes() {
        this.food = budget.getExpenses(FOOD);
        this.entertainment = budget.getExpenses(ENTERTAINMENT);
        this.clothes = budget.getExpenses(CLOTHES);
        this.other = budget.getExpenses(OTHER);
        this.all = budget.getExpenses(ALL);
    }

}
