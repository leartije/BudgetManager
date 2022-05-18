package budget;

import java.util.Collections;

import static budget.Categories.*;
import static budget.MenusAndMsg.*;
public class Sorting {
    private final BudgetClass budget;
    private double food;
    private double entertainment;
    private double clothes;
    private double other;
    private double all;

    public Sorting(BudgetClass budget) {
        this.budget = budget;
    }

    protected void sortAll() {
        if (budget.getItemList().size() == 0) {
            System.out.println(EMPTY_PURCHASE_LIST_MSG);
            return;
        }
        Collections.sort(budget.getItemList());
        System.out.println("All:");
        budget.getItemList().forEach(System.out::println);
        System.out.printf(TOTAL_SUM_MSG, budget.getExpenses(ALL));
    }

    protected void sortByCertainType() {
        setTypes();
        System.out.printf(
                TYPES_ANALYZE_MSG,
                food, entertainment,
                clothes,
                other,
                all
        );
    }

    protected void sortByCertainType(Categories category) {
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
