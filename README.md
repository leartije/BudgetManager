# BudgetManager
Jetbrains academy project in 5 stages

Stage 1/5: Count my money

Description:

First, let’s implement the counting of your purchases. It’s much easier to analyze when your expenses are presented as a list. Read data from the console and at the end show the list of all purchases and its total amount.
It should be displayed as follows: Total: $23.00

Your program should process every line the user inputs. To end the input, the user should type End-of-file symbol that tells your operating system that no more input will be provided. It's Ctrl+D on Linux and Mac and Ctrl+Z on Windows. Don't be scared: you don’t have to implement it yourself, this is a special built-in hot-key that gives the command to stop input. See for yourself!

Stage 2/5: Make a menu

Description:

Let's make your application more convenient. Only counting the expenses is a little bit sad, right?

To make your application flexible and functional, add a menu that consists of 4 items.

1. Add Income. We must track both our expenses and our income. When this item is selected, the program should ask to enter the amount of income.
2. Add Purchase. This item should add a purchase to the list. You have implemented this feature in the previous stage.
3. Show the list of purchases. This menu item should display a list of all expenses and incomes in the order they were made.
4. Balance. Show the balance.
5. Exit. Exit the program. Make this item under number 0, not number 5.

Notice, that the amount of remaining money cannot be negative. In this case, make the balance equal to $0.

When displaying the price or the total amount, print 2 numbers after the point.
Example: $14.20
Follow this rule in the next stages.

Stage 3/5: Oh the things you can buy

Description:

To better control the expenses, we need to categorize our purchases. It helps to see how exactly your budget is distributed: you may be actually quite surprised!

Implement a function that assigns a purchase to a specific category.

The program should have the following categories:
Food
Clothes
Entertainment
Other

The function allows you to output the shopping list by type. After selecting the action of showing the list of expenses, offer to show either a certain category or a general list. At the end print the total amount of purchases that are on the list.

Stage 4/5: Memorable purchases

Description:

What's the point of counting the money if the results are lost and forgotten once you close the program? To allow for some long-term budget planning, we need to save purchases to file. Add items Save and Load to the menu.

Save should save all purchases to the file.
Load should load all purchases from the file.

Use the purchases.txt file to store purchases.

Stage 5/5: Analyzer

Description:

Do you know how much money you spend on food? On entertainment? It's quite interesting to know since the main purpose of this application is to analyze your expenses. Let's implement this feature!

First, add the Analyze item to the menu. This way you will request an analysis of your purchases.

Once this item is called you need to offer a way to sort the purchases.

There are three of them:

- Sort All – sort the entire shopping list and display it so that the most expensive purchases are at the top of the list.
- Sort By Type – show which category eats the most money. If a category has no purchases in it the total sum should be $0.
- Sort Certain Type – same as Sort All, but for a specific category.

