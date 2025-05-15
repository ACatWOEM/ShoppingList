import java.util.Scanner;//import scanner
import java.util.ArrayList;//import ArrayList
import java.util.InputMismatchException;//import the catch for input mismatch exceptions
import java.io.File;//import File for creating file objects
import java.io.FileNotFoundException;//import the file not found exception for catching and creating new files
import java.io.FileWriter;//import the fileWriter for writing to files
import java.io.IOException;//import the IO exception for catching IO errors

public class Main {
	static Scanner scnr = new Scanner(System.in);//initialize the scanner for system input
	static ArrayList<Item> itemList = new ArrayList<Item>();//initialize a static array list named ItemList for storing new Item objects
	public static void printMainMenu() {//method for printing the main menu options
		System.out.println("-MAIN MENU-");
		System.out.println("I - Manage items");
		System.out.println("B - set Budget");
		System.out.println("D - Display List and remaining budget");
		System.out.println("O - Organization options");
		System.out.println("Q - Quit");
		System.out.println("Please choose an option: ");
	}
	public static void printOrganizationOptionsMenu() {//method for printing the organization options menu
		System.out.println("-ORGANIZATION OPTIONS-");
		System.out.println("A - Organize by price(Ascending)");
		System.out.println("D - Organize by price(Descending)");
		System.out.println("G - Organize by group");
		System.out.println("Q - Return to main menu");
		System.out.println("Please choose an option: ");
	}
	public static void printManageItemsMenu() {//method for printing the manage items menu
		System.out.println("-MANAGE ITEMS-");
		System.out.println("A - Add item");
		System.out.println("R - Remove item");
		System.out.println("S - Search item");
		System.out.println("C - Clear list");
		System.out.println("Q - Return to main menu");
		System.out.println("Please choose an option: ");
		
	}
	public static void organizationOptionsMenu(Scanner scnr) {//method for navigating the organization options menu
		String input;//initialize String variable input
		
		do{//start do while loop, will allow for uppercase and lowercase input
			printOrganizationOptionsMenu();//always display organizationsOptionsMenu first
			input = scnr.nextLine();//input is assigned with scnr.nextLine();
			if (input.equalsIgnoreCase("a")) {//if branch for if input is p or P
				organizeByPriceAscending();;//call organizeByPrice and pass the scanner
				printArrayList();//call printarraylist to display organized shopping list
				return;
			}
			else if(input.equalsIgnoreCase("d")) {//if d
				organizeByPriceDescending();//call orgaizeByPriceDescending
				printArrayList();//call printarraylist to display organized shopping list
				return;
			}
			else if(input.equalsIgnoreCase("g")) {//else if branch for if input is g or G
				itemList = organizeByGroup();//call organizeByGroup and pass the scanner
				printArrayList();//call printarraylist to display organized shopping list
				return;
			}
			else if(input.equalsIgnoreCase("q")) {//if q
				System.out.println();//print a line and return
			}
			else{//else alert user of invalid input
				System.out.println("!INVALID INPUT!");//println
			}
		}while(!input.equalsIgnoreCase("q"));//do while input is not r or R
		return;//return
	}
	public static void manageItemsMenu(Scanner scnr) {//method for navigating the manage items menu
		String input;
		
		do {
			printManageItemsMenu();//display manage items menu
			input = scnr.nextLine();//input is the scanners next line
			if(input.equalsIgnoreCase("a")) {//ignore case, if input is a
				createItem(scnr);//call create item and pass the scanner
			}
			else if(input.equalsIgnoreCase("r")) {//ignore case, if input is r
				removeItem(scnr);//call the remove item method and pass the scanner
			}
			else if(input.equalsIgnoreCase("s")) {//ignore case, if input is s
				searchItem(scnr);//call searchItem method and pass the scanner
			}
			else if(input.equalsIgnoreCase("c")) {//ignore case, if input is c
				clearList();//call the clearList method
			}
			else if(input.equalsIgnoreCase("q")) {//ignore case if input is q
				System.out.println();//print a line and then return
			}
			else {//else
				System.out.println("!INVALID INPUT!");//warn user of invalid input
			}
		}while(!input.equalsIgnoreCase("q"));//do while input isn't q, ignoring case.
		
	}
	public static void setBudget(Scanner scnr) {
		//TODO create a budget class in order to create different budget objects
		
		return;
	}
	public static void organizeByPriceAscending() {
		for(int j = 0; j < itemList.size() - 1; ++j) {	
			for(int i = 0; i < itemList.size() - 1; ++i) {
				Item item1 = itemList.get(i);
				if(i != itemList.size()) {
					Item item2 = itemList.get(i+1);
					if(item1.getItemPrice() > item2.getItemPrice()) {
						itemList.set(i, item2);
						itemList.set(i+1, item1);
					}
					else if(item1.getItemPrice() < item2.getItemPrice()) {
						itemList.set(i, item1);
						itemList.set(i+1, item2);					
					}
				}
				else {
				}
			}
		}
		return;
	}
	public static void organizeByPriceDescending() {
		for(int j = 0; j < itemList.size() - 1; ++j) {	
			for(int i = 0; i < itemList.size() - 1; ++i) {
				Item item1 = itemList.get(i);
				if(i != itemList.size()) {
					Item item2 = itemList.get(i+1);
					if(item1.getItemPrice() < item2.getItemPrice()) {
						itemList.set(i, item2);
						itemList.set(i+1, item1);
					}
					else if(item1.getItemPrice() > item2.getItemPrice()) {
						itemList.set(i, item1);
						itemList.set(i+1, item2);					
					}
				}
				else {
				}
			}
		}
		return;
	}
	public static ArrayList<Item> organizeByGroup() {
	    ArrayList<String> typeList = new ArrayList<String>();
	    ArrayList<Item> sortedList = new ArrayList<Item>();
	    for(int i =0 ; i < itemList.size(); ++i) {
	    	Item tempItem = itemList.get(i);
	        if(!typeList.contains(tempItem.getItemType())) {
	            typeList.add(tempItem.getItemType());
	        }
	    }
	    for(int i = 0; i < typeList.size(); ++i) {
	    	String type = typeList.get(i);
	        for(int j = 0; j < itemList.size(); ++j) {
	        	Item tempItem = itemList.get(j);
	            if(tempItem.getItemType().equals(type)) {
	                sortedList.add(tempItem);
	            }
	        }
	    }   
	    return sortedList;
	}
	public static double calculateTotal() {//method for calculating the total of the entire shopping list
		double total = 0.00;//initialize total with 0.00
		for(int i = 0 ; i < itemList.size(); ++i) {//for loop iterates through the size of itemList
			Item tempItem = itemList.get(i);//assign new object tempItem with object at i index of itemList
			total += tempItem.getItemTotal();//increment total by calling getItemTotal for tempItem
		}
		return total;//return the double total
	}
	public static double calculateTotalPlusTax() {
		double total = calculateTotal();//initialize double total and assign it using the calculate total method
		total = total + (total * .0725);//calculate the total plus the California sales tax of 7.25%
		return total;//return the total with tax factored in
	}
	public static void createItem(Scanner scnr) {//method for creating new Item objects and putting them in the itemList ArrayList
		Item newItem = new Item();//create the new item
		boolean isValidInput;//boolean variable for handling exceptions later on
		//assign itemPrice
		System.out.println("Please enter an item name:");//prompt
		newItem.setItemName(scnr.nextLine());//call setItemName and read next line
		//assign itemType
		System.out.println("Specify an item type:");//prompt
		newItem.setItemType(scnr.nextLine());//call setItemType and read next line
		//do while with exceptions to assign itemPrice
		do {
			isValidInput = false;//assign isValidInput with false
		try {
			System.out.println("Set an item price:");//prompt
			newItem.setItemPrice(scnr.nextDouble());//call setItemPrice and read next double
			isValidInput = true;//if input is acceptable, set isValidInput to true
		}
		catch(InputMismatchException e) {//if input is not acceptable, catch exception
			System.out.println("!PLEASE USE NUMBERS TO INPUT THE ITEM PRICE!");//alert user
			scnr.nextLine();//clear the scanner
		}
		}while(!isValidInput);//do this while isValidInput is false
		//do while with exceptions to assign itemQuantity
		do {
			isValidInput = false;//assign isValidInput with false
		try {
			System.out.println("Quantity of item:");//prompt
			newItem.setItemQuantity(scnr.nextInt());//call setItemQuantity and read next Int
			isValidInput = true;//if input is acceptable, set isValidInput to true
		}
		catch(InputMismatchException e) {//if input is not acceptable, catch exception
			System.out.println("!PLEASE USE WHOLE NUMBERS TO INPUT ITEM QUANTITY!");//alert user
			scnr.nextLine();//clear the scanner
		}
		}while(!isValidInput);//do this while isValidInput is false
		itemList.add(newItem);//add object newItem to ArrayList itemList
		
		System.out.print("YOU ADDED: ");//readback
		newItem.printItemInfo();//call printItemInfo for object newItem
		
		scnr.nextLine();//clear the scanner
		return;
	}
	public static void removeItem(Scanner scnr) {//method for removing an item from the shopping list
		String choice = "";//initialize string choice
		Item tempItem;//create a temp item from the Item class
		System.out.println("-ITEMS ON LIST-");//text
		displayItemNames();//call the displayItemNames method to display a choice of items for the user
		System.out.println("Please select an item from list for removal");//text
		choice = scnr.nextLine();//assign choice with the nextLine from scnr
		for(int i = 0 ; i < itemList.size(); ++i) {//for loop iterates the size of itemLIst
			tempItem = itemList.get(i);//tempItem is assigned with the item from itemlist at i
			if(choice.equalsIgnoreCase(tempItem.getItemName())) {//if choice is the same as the temp item, ignoring case
				System.out.println(tempItem.getItemName() + " removed");//print the item name, removed
				itemList.remove(i);//remove the item from the itemList arrayList at index i
			}
		}
	}
	public static void searchItem(Scanner scnr) {//method for displaying information about a specific item on shopping list
		String choice = "";//initialize string choice
		Item tempItem;//create a new Item tempItem
		System.out.println("-ITEMS ON LIST-");//text
		displayItemNames();//call the displayItemNames method to display a choice of items for the user
		System.out.println("Please select which item you wish to see information about: ");//text
		choice = scnr.nextLine();//choice assigned with scnr nextLine
		for(int i = 0 ; i < itemList.size(); ++i) {//for loop iterates through the itemList size
			tempItem = itemList.get(i);//the temp item is assigned with the object at the i index of itemLIst
			if(choice.equalsIgnoreCase(tempItem.getItemName())) {//check if choice is the same as the tempItem name, ignore case
			tempItem.printItemInfo();//call the item class method for printing the info of temp item
			}
		}	
	}
	public static void clearList() {//method clears list, but ensures that the user wants to clear the list, since there is no getting it back once it's cleared
		String choice = "";//initialize the string choice.
		do {//start do while loop
			System.out.println("ARE YOU SURE YOU WANT TO CLEAR YOUR SHOPPING LIST?");//warn user
			System.out.println("Y - YES || N - NO");//prompt options
			choice = scnr.nextLine();//assign choice with the scanners next line
			if(choice.equalsIgnoreCase("y")) {//check if choice equals y, ignore case
				if(itemList.size() > 0) {//if the list size is more than 0
					itemList.clear();//clear arraylist itemList
					System.out.println("List cleared");//say list cleared
					return;//return
				}
				else {//else
					System.out.println("List is empty");//tell user list is empty
					return;
				}
			}
			else if(choice.equalsIgnoreCase("n")) {//if the user enters no
				return;//return
			}
			else {//otherwise
				System.out.println("!PLEASE ENTER A VALID INPUT!");//prompt user to enter a valid input
			}
		}while(!choice.equalsIgnoreCase("y") || !choice.equalsIgnoreCase("n"));//do this while choice is neither y or n, ignore case. 
	}
	public static void displayItemNames() {//method for displaying item names to help user choose from a list of item names
		Item tempItem;//create Item object tempItem
		for(int i = 0 ; i < itemList.size(); ++i) {//for loop iterates through the size of the itemList arrayList
			tempItem = itemList.get(i);//assign tempItem with the object at the i index of itemLIst
			if(i < itemList.size() - 1) {//if statement checks if we are at the last index of itemList
				System.out.print(tempItem.getItemName() + ", ");//comma after item name
			}
			else if(i == itemList.size() - 1) {//if at the end of itemLIst
				System.out.print(tempItem.getItemName());//no comma after itemName
			}
		}
		System.out.println();//new line
	}
	public static void printArrayList() {//displaying the shopping list
		int count = 0;//count will be used to display total items on shopping list
		for(int i = 0 ; i < itemList.size(); i++) {//for loop iterates through the size of itemList
			Item tempItem = itemList.get(i);//assign new tempItem with the object at the i index of itemList ArrayList
			tempItem.printItemInfo();//call the printItemInfo getter with the temp item
			count += tempItem.getItemQuantity();//add the itemQuantity to count
		}
		if(count > 1) {//if branch for proper grammar when displaying amount of items on list
			System.out.println(count + " items on list");//println
		}
		else if(count == 1) {//else if branch for proper grammar when displaying amount of items on list
			System.out.println(count + " item on list");//println
		}
		else {//else branch in case there are no items on the list
			System.out.println("No items on list");//println
		}
		System.out.print("Total: $");//total
		System.out.printf("%.2f\n", calculateTotal());//printf calls the calculate total method, and formats it
		System.out.print("Total + tax: $");//total plus tax
		System.out.printf("%.2f\n", calculateTotalPlusTax());//printf calls the calculate total plus tax method, and formats it
		return;
	}
	public static void openList(Scanner fileScan) {
		while (fileScan.hasNextLine()){
			Item newItem = new Item();//create the new item
			newItem.setItemName(fileScan.nextLine());//call setItemName and read next line
			newItem.setItemType(fileScan.nextLine());//call setItemType and read next line
			newItem.setItemPrice(fileScan.nextDouble());//call setItemPrice and read next double
			newItem.setItemQuantity(fileScan.nextInt());//call setItemQuantity and read next Int
			itemList.add(newItem);//add object newItem to ArrayList itemList
			fileScan.nextLine();
		}
	}
	public static void saveList(File file, Scanner fileScan)throws IOException {//saveList writes a itemList to a file
		String fileContent="";//create new string called fileContent
		FileWriter writer = new FileWriter("src/ShoppingList.txt");//file writer named writer writes to the relative path src/shoppinglist.txt
		fileContent = scanItemList();//fileContent calls scanItemList method
		writer.write(fileContent);//writer writes the fileContent to the file
		writer.close();//close the writer
	}
	//could probably merge saveList and scanItemList
	public static String scanItemList() {//scan itemList scans the arrayList and writes it to a file
		String buildList = "";//initialize a String buildList
		for(int i = 0; i < itemList.size(); ++i) {//for loop iterates through the size of itemList
			Item tempItem = itemList.get(i);//create a new Item object called tempItem from the i index of itemList
			buildList = buildList.concat(tempItem.getItemName() + "\n");//concat onto buildlist the getItemName getter for tempItem, new Line
			buildList = buildList.concat(tempItem.getItemType() + "\n");//concat onto buildlist the getItemType getter for tempItem, new Line
			buildList = buildList.concat(tempItem.getItemPrice() + "\n");//concat onto buildlist the getItemPrice getter for tempItem, new Line
			buildList = buildList.concat(tempItem.getItemQuantity() + "\n");//concat onto buildlist the getItemQuantity getter for tempItem, new Line
			buildList = buildList.concat("");//idk
		}
		return buildList;//return buildList
	}
	public static void main(String[] args) throws IOException {//main executes the main menu for the most part
		try {//main will try all of it's main functions
			File file = new File("src/ShoppingList.txt");
			Scanner fileScan = new Scanner(file);
			String input;//initialize String variable input
			openList(fileScan);
			do{//do while loop starts, branches will allow lowercase and uppercase
				printMainMenu();//always start by printing the main menu
				input = scnr.nextLine();//input is the nextLine
				if(input.equalsIgnoreCase("i")) {//if branch with ignorecase for option m
					manageItemsMenu(scnr);//call manageItemsMenu and pass the scnr
				}
				else if(input.equalsIgnoreCase("b")) {//else if branch with ignorecase for option b
					setBudget(scnr);//call setBudget and pass the scnr
				}
				else if(input.equalsIgnoreCase("d")) {//else if branch with ignorecase for option d
					printArrayList();//call printArrayList and pass the scnr
				}
				else if(input.equalsIgnoreCase("o")) {//else if branch with ignorecase for option o
					organizationOptionsMenu(scnr);//call organizationOptions and pass the scnr
				}
				else if(input.equalsIgnoreCase("q")) {//else if branch with ignorecase for option q
					saveList(file, fileScan);
					System.out.println("Quitting");//printline to let user no program is terminating
				}
				else {
					System.out.println("!INVALID INPUT!");//else alert user of invalid input
				}
			}while(!input.equalsIgnoreCase("q"));//do this while input is not q
			scnr.close();//close the scanner
			fileScan.close();
		}
		catch(FileNotFoundException e) {//if there is no shoppingList.txt file, main will catch this exception and create shoppinglist.exe, and return to main with a null argument
			FileWriter writer = new FileWriter("src/ShoppingList.txt");
			writer.close();
			main(null);
		}
	}
}