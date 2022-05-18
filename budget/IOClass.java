package budget;

import java.io.*;

public class IOClass {


    private final File file;
    private final BudgetClass budgetClass;

    public IOClass(File file, BudgetClass budgetClass) {
        this.file = file;
        this.budgetClass = budgetClass;
    }

    public boolean save() {
        try (FileWriter fw = new FileWriter(file)) {
            for (int i = 0; i < budgetClass.getItemList().size(); i++) {
                Item current = budgetClass.getItemList().get(i);
                fw.write(current.getItemName() +
                        "|" + current.getItemPrice() +
                        "|" + current.getCategories() + "\n"
                );
            }
            fw.write(String.valueOf(budgetClass.getBalance()));
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
                    budgetClass.getItemList().add(new Item(
                            splitCurrent[0],
                            Double.parseDouble(splitCurrent[1]),
                            Categories.valueOf(splitCurrent[2]))
                    );
                } else {
                    budgetClass.setBalance(Double.parseDouble(splitCurrent[0]));
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
