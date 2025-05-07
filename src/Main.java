import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
	static Scanner scnr = new Scanner(System.in);//initialize the scanner for system input
	static ArrayList<Item> itemList = new ArrayList<Item>();//initialize a static array list named ItemList for storing new Item objects
	public static void printMainMenu() {//method for printing the main menu options
		System.out.println("-MAIN MENU-");
		System.out.println("I - Manage items");
		System.out.println("B - set Budget");
		System.out.println("D - Display List and remaining budget");
		System.out.println("O - Organization options");
		System.out.println("T - Calculate total + tax");
		System.out.println("Q - Quit");
		System.out.println("Please choose an option: ");
	}
	public static void printOrganizationOptionsMenu() {//method for printing the organization options menu
		System.out.println("-ORGANIZATION OPTIONS-");
		System.out.println("P - Organize by price");
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
			if (input.equalsIgnoreCase("p")) {//if branch for if input is p or P
				organizeByPrice(scnr);//call organizeByPrice and pass the scanner
			}
			else if(input.equalsIgnoreCase("g")) {//else if branch for if input is g or G
				organizeByGroup(scnr);//call organizeByGroup and pass the scanner
			}
			else if(input.equalsIgnoreCase("q")) {
				System.out.println();
			}
			else{//else alert user of invalid input
				System.out.println("!INVALID INPUT!");//println
			}
		}while(!input.equalsIgnoreCase("q"));//do while input is not r or R
		return;
	}
	public static void manageItemsMenu(Scanner scnr) {//method for navigating the manage items menu
		String input;
		
		do {
			printManageItemsMenu();
			input = scnr.nextLine();
			if(input.equalsIgnoreCase("a")) {
				createItem(scnr);
			}
			else if(input.equalsIgnoreCase("r")) {
				removeItem(scnr);
			}
			else if(input.equalsIgnoreCase("s")) {
				searchItem(scnr);
			}
			else if(input.equalsIgnoreCase("c")) {
				clearList();
			}
			else if(input.equalsIgnoreCase("q")) {
				System.out.println();
			}
			else {
				System.out.println("!INVALID INPUT!");
			}
		}while(!input.equalsIgnoreCase("q"));
		
	}
	public static void setBudget(Scanner scnr) {
		//TODO create a budget class in order to create different budget objects
		
		return;
	}
	public static void organizeByPrice(Scanner scnr) {
		/*
		 * TODO for loop with if else if branches for whether or not a price at index i is higher or lower than the the former index, deciding 
		 * which way to push object in index (up or down)this might be a nested for loop to ensure that every price is properly sorted
		 */
	
		return;
	}
	public static void organizeByGroup(Scanner scnr) {
		/*
		 *TODO a nested for loop will iterate through ArrayList multiple times to find matching itemTypes, each time it finds a matching itemType that index will be added to a new ArrayList
		 *old ArrayList will be scanned again and again until the new arrayList matches the size of the old ArrayList, this method will return the new ArrayList, replacing the old one.
		 *NOTE: it might be helpful to make an ArrayList for already encountered itemTypes so that way we can ignore already sorted itemTypes
		 */
		
		return;
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
		double total = calculateTotal();
		total = total + (total * .0725);//calculate the total plus the California sales tax of 7.25%
		return total;
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
		String choice = "";
		Item tempItem;
		System.out.println("-ITEMS ON LIST-");
		displayItemNames();
		System.out.println("Please select an item from list for removal");
		choice = scnr.nextLine();
		for(int i = 0 ; i < itemList.size(); ++i) {
			tempItem = itemList.get(i);
			if(choice.equalsIgnoreCase(tempItem.getItemName())) {
				System.out.println(tempItem.getItemName() + " removed");
				itemList.remove(i);
			}
		}
	}
	public static void searchItem(Scanner scnr) {//method for displaying information about a specific item on shopping list
		String choice = "";
		Item tempItem;
		System.out.println("-ITEMS ON LIST-");
		displayItemNames();
		System.out.println("Please select which item you wish to see information about: ");
		choice = scnr.nextLine();
		for(int i = 0 ; i < itemList.size(); ++i) {
			tempItem = itemList.get(i);
			if(choice.equalsIgnoreCase(tempItem.getItemName())) {
			tempItem.printItemInfo();
			}
		}	
	}
	public static void clearList() {
		if(itemList.size() > 0) {
			itemList.clear();
			System.out.println("List cleared");
		}
		else {
			System.out.println("List is empty");
		}
	}
	public static void displayItemNames() {//method for displaying item names to help user choose from a list of item names
		Item tempItem;
		for(int i = 0 ; i < itemList.size(); ++i) {
			tempItem = itemList.get(i);
			if(i < itemList.size() - 1) {
				System.out.print(tempItem.getItemName() + ", ");
			}
			else if(i == itemList.size() - 1) {
				System.out.print(tempItem.getItemName());
			}
		}
		System.out.println();
	}
	public static void printArrayList(Scanner scnr) {//displaying the shopping list
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
	public static void saveList(File file, Scanner fileScan)throws IOException {
		String fileContent="";
		FileWriter writer = new FileWriter("C:/Users/Richard/Desktop/EclipseWorkspace/ShoppingList/src/ShoppingList.txt");
		fileContent = fileContent.concat(scanItemList());
		writer.write(fileContent);
		writer.close();
	}
	public static String scanItemList() {
		String buildList = "";
		for(int i = 0; i < itemList.size(); ++i) {
			Item tempItem = itemList.get(i);
			buildList = buildList.concat(tempItem.getItemName() + "\n");
			buildList = buildList.concat(tempItem.getItemType() + "\n");
			buildList = buildList.concat(tempItem.getItemPrice() + "\n");
			buildList = buildList.concat(tempItem.getItemQuantity() + "\n");
			buildList = buildList.concat("");
		}
		return buildList;
	}
	public static void main(String[] args) throws IOException {//main executes the main menu for the most part
		File file = new File("C:/Users/Richard/Desktop/EclipseWorkspace/ShoppingList/src/ShoppingList.txt");
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
				printArrayList(scnr);//call printArrayList and pass the scnr
			}
			else if(input.equalsIgnoreCase("o")) {//else if branch with ignorecase for option o
				organizationOptionsMenu(scnr);//call organizationOptions and pass the scnr
			}
			else if(input.equalsIgnoreCase("t")) {//else if branch with ignorecase for option t
				calculateTotal();//call calculateTotal and pass the scnr
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
}