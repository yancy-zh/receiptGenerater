## Project structure

The application is only contained in the folder "receiptGenerater". src/main/java contains the source codes and src/test/java contains the test codes.

## Dependencies

- Java JDK version should be higher than 15
- Import and build the project using Eclipse, and configue "receiptGenerater" as the project name, "receiptGenerater.App" as the main class.
- Installed Java EE, Java SE, maven plugins, web tools platform in Eclipse

## Assumption

Since the task has no strict definition of the three categories of products which satisfy basic sales exemption, to ensure that the application works as required, I assume that

- the medical products include any word that is one of the following: pill, pills, medicine
- books include any word that is one of the following: book(s), magazine(s)
- food includes any word that is one of the following: chocolate, candy
- the price appears after the "at" keyword
- the amount appears at the first word, using the space(or multiple spaces) as the delimiter
  **_for the definitions above, see the class file ShoppingItem.java_**
- if the amount is not 1, then

1. the price for the shopping item = price for single item \* amount
2. the tax for the shopping item = tax for single item \* amount
   **_for the definitions above, see the class file Receipt.java_**

## Build the export the application as a jar file

In Eclipse, open the project folder "receiptGenerater", right click the project name, click "export", choose "as Runnable JAR file", go to the next step, type in a path for export destination, click "finish".

## Run the application

1. (use Eclipse to run the application) Right click the "App.java" file and run as an java application.

2. (use jar executable file) Store the jar file built from the application in a certain path, open the terminal from this path, type

   > java -jar JAR_NAME.jar

   For example,

   > java -jar receiptGenerater.jar

   when asked to type the full file name of the input txt file, type or paste the correct absolute path to the file, e.g.:

   > C:\Users\Administrator\eclipse-java-workspace\assignment_yao\receiptGenerater\src\receiptGenerater\shoppingList.txt

---

## Unit test

Due to the dependency set up of junit being incomplete(slow network connection), the tests can't be compiled thus not all test cases were written. The tests can be find in the folder "receiptGenerater\test\".

## Task description

Hi.

Below you will find 3 Problems out of which we ask you to solve exactly one.
We know that the problems below are far from unknown and you will find solutions to them everywhere on github. We encourage you to create your own solution - please don't cheat ;)
Please focus on code quality and make production ready code. We ask you to work test driven and make commits so we can understand your process. You are free to use build systems and libraries the same way you would build real-world software.  
You are an admin of this repository. Feel free to modify settings to your liking and work with this repository exactly as you would use any other project repository by commiting to it.  
Please also add a file that gives us hints on how to build it, and the assumptions that you made.  
We would ask you to finish within two weeks, but inform us if you need more time. Once you are confident with your solution, send us an email so we can freeze the repository.

## Problem 1: SALES TAXES

Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax
applicable on all imported goods at a rate of 5%, with no exemptions. When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items,
and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

Write an application that prints out the receipt details for these shopping baskets...

### INPUT:

Input 1:

> 1 book at 12.49  
> 1 music CD at 14.99  
> 1 chocolate bar at 0.85

Input 2:

> 1 imported box of chocolates at 10.00  
> 1 imported bottle of perfume at 47.50

Input 3:

> 1 imported bottle of perfume at 27.99  
> 1 bottle of perfume at 18.99  
> 1 packet of headache pills at 9.75  
> 1 box of imported chocolates at 11.25

### OUTPUT

Output 1:

> 1 book: 12.49  
> 1 music CD: 16.49  
> 1 chocolate bar: 0.85  
> Sales Taxes: 1.50  
> Total: 29.83

Output 2:

> 1 imported box of chocolates: 10.50  
> 1 imported bottle of perfume: 54.65  
> Sales Taxes: 7.65  
> Total: 65.15

Output 3:

> 1 imported bottle of perfume: 32.19  
> 1 bottle of perfume: 20.89  
> 1 packet of headache pills: 9.75  
> 1 imported box of chocolates: 11.85  
> Sales Taxes: 6.70  
> Total: 74.68
