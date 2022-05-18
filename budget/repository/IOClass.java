package budget.repository;

import budget.staticandenums.Categories;
import budget.item.Item;
import budget.services.BudgetServices;

import java.io.*;

public class IOClass {
    private final File file;
    private final BudgetServices budgetServices;

    public IOClass(File file, BudgetServices budgetServices) {
        this.file = file;
        this.budgetServices = budgetServices;
    }

    public boolean save() {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < budgetServices.getItemList().size(); i++) {
                Item current = budgetServices.getItemList().get(i);
                fw.write(current.getItemName() +
                        "|" + current.getItemPrice() +
                        "|" + current.getCategories() + "\n"
                );
            }
            fw.write(String.valueOf(budgetServices.getBalance()));
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public boolean load() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitCurrent = line.split("\\|");
                if (splitCurrent.length == 3) {
                    budgetServices.getItemList().add(new Item(
                            splitCurrent[0],
                            Double.parseDouble(splitCurrent[1]),
                            Categories.valueOf(splitCurrent[2]))
                    );
                } else {
                    double fileBalance = Double.parseDouble(splitCurrent[0]);
                    budgetServices.setBalance(-budgetServices.getBalance());
                    budgetServices.setBalance(fileBalance);
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
