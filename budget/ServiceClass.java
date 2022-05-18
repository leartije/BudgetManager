package budget;

import java.io.File;

import static budget.Categories.*;
import static budget.Main.scanner;
import static budget.MenusAndMsg.*;

public class ServiceClass {

    private final BudgetClass budget;
    private final IOClass ioClass;
    private final Sorting sorting;

    public ServiceClass() {
        this.budget = new BudgetClass();
        File file = new File(FILE_NAME);
        this.ioClass = new IOClass(file, this.budget);
        this.sorting = new Sorting(this.budget);
    }

    public void startProgram() {
        while (true) {
            mainMenuMsg();
            String option = scanner.nextLine();
            System.out.println();
            switch (option) {
                case "1":
                    budget.addIncome();
                    break;
                case "2":
                    purchaseSubmenu();
                    break;
                case "3":
                    showListSubmenu();
                    break;
                case "4":
                    budget.showBalance();
                    break;
                case "5":
                    boolean isSave = ioClass.save();
                    if (isSave) {
                        System.out.println(SAVE_MSG);
                        break;
                    }
                    System.out.println(ERROR_MSG);
                    break;
                case "6":
                    boolean isLoad = ioClass.load();
                    if (isLoad) {
                        System.out.println(LOAD_MSG);
                        break;
                    }
                    System.out.println(ERROR_MSG);
                    break;
                case "7":
                    analyseSubmenu();
                    break;
                case "0":
                    System.out.println(BYE_MSG);
                    System.exit(0);
                    break;
                default:
                    System.out.printf(WRONG_INPUT_MSG, option);
                    break;
            }
        }
    }

    private void purchaseSubmenu() {
        boolean back = false;
        while (!back) {
            purchaseSubmenuMsg();
            String option = scanner.nextLine();
            System.out.println();
            switch (option) {
                case "1":
                    budget.purchase(FOOD);
                    break;
                case "2":
                    budget.purchase(CLOTHES);
                    break;
                case "3":
                    budget.purchase(ENTERTAINMENT);
                    break;
                case "4":
                    budget.purchase(OTHER);
                    break;
                case "5":
                    back = true;
                    startProgram();
                    break;
                default:
                    System.out.printf(WRONG_INPUT_MSG, option);
                    break;
            }
        }
    }

    private void showListSubmenu() {
        boolean back = false;
        while (!back) {
            showPurchasesMenuMsg();
            String option = scanner.nextLine();
            System.out.println();
            switch (option) {
                case "1":
                    budget.showListOfPurchases(FOOD);
                    break;
                case "2":
                    budget.showListOfPurchases(CLOTHES);
                    break;
                case "3":
                    budget.showListOfPurchases(ENTERTAINMENT);
                    break;
                case "4":
                    budget.showListOfPurchases(OTHER);
                    break;
                case "5":
                    budget.showListOfPurchases(ALL);
                    break;
                case "6":
                    startProgram();
                    back = true;
                    break;
                default:
                    System.out.printf(WRONG_INPUT_MSG, option);
                    break;
            }
        }
    }

    private void analyseSubmenu() {
        boolean back = false;
        while (!back) {
            analyseSubmenuMsg();
            String option = scanner.nextLine();
            System.out.println();
            switch (option) {
                case "1":
                    sorting.sortAll();
                    break;
                case "2":
                    sorting.sortByCertainType();
                    break;
                case "3":
                    analyzeSubSubMenu();
                    analyseSubmenu();
                    break;
                case "4":
                    startProgram();
                    back = true;
                    break;
                default:
                    System.out.printf(WRONG_INPUT_MSG, option);
                    break;
            }
        }
    }

    private void analyzeSubSubMenu() {
        sortByTypeSubmenuMsg();
        String options = scanner.nextLine();
        System.out.println();
        switch (options) {
            case "1":
                sorting.sortByCertainType(FOOD);
                break;
            case "2":
                sorting.sortByCertainType(CLOTHES);
                break;
            case "3":
                sorting.sortByCertainType(ENTERTAINMENT);
                break;
            case "4":
                sorting.sortByCertainType(OTHER);
                break;
            default:
                System.out.printf(WRONG_INPUT_MSG, options);
                break;
        }
    }


}
