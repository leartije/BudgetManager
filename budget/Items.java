package budget;

public class Items {

    private final String itemName;
    private final double itemPrice;

    public Items(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f", itemName, itemPrice);
    }
}
