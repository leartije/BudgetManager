package budget;

import budget.repository.IOClass;
import budget.services.BudgetServices;
import budget.services.SortingServices;

import java.io.File;

import static budget.staticandenums.Categories.*;
import static budget.Main.scanner;
import static budget.staticandenums.MenusAndMsg.*;

public class BudgetManager {

    private final BudgetServices budget;
    private final IOClass ioClass;
    private final SortingServices sortingServices;

    public BudgetManager() {
        this.budget = new BudgetServices();
        File file = new File(FILE_NAME);
        this.ioClass = new IOClass(file, this.budget);
        this.sortingServices = new SortingServices(this.budget);
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
                    sortingServices.sortAll();
                    break;
                case "2":
                    sortingServices.sortByCertainType();
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
                sortingServices.sortByCertainType(FOOD);
                break;
            case "2":
                sortingServices.sortByCertainType(CLOTHES);
                break;
            case "3":
                sortingServices.sortByCertainType(ENTERTAINMENT);
                break;
            case "4":
                sortingServices.sortByCertainType(OTHER);
                break;
            default:
                System.out.printf(WRONG_INPUT_MSG, options);
                break;
        }
    }


}
