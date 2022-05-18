package budget.item;

import budget.staticandenums.Categories;

public class Item implements Comparable<Item> {
    private final String itemName;
    private final double itemPrice;
    private final Categories categories;

    public Item(String itemName, double itemPrice, Categories categories) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.categories = categories;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public Categories getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f", itemName, itemPrice);
    }

    @Override
    public int compareTo(Item o) {
        return Double.compare(o.itemPrice, this.itemPrice);
    }
}
