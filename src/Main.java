import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class Main {
	
	static Scanner scnr = new Scanner(System.in);
	static ArrayList<Item> itemList = new ArrayList<Item>();
	
	public static void printMainMenu() {
		System.out.println("-MENU-");
		System.out.println("A - add Item");// in the future open "manage items" options to add item, remove item, search items, etc.
		System.out.println("B - set Budget");
		System.out.println("D - Display List and remaining budget");
		System.out.println("O - Organization options");
		System.out.println("T - Calculate total + tax");
		System.out.println("Q - Quit");
		System.out.println("Please choose an option: ");
	}
	public static void printOrganizationOptionsMenu() {
		System.out.println("-ORGANIZATION OPTIONS-");
		System.out.println("P - Organize by price");
		System.out.println("G - Organize by group");
		System.out.println("R - Return to menu");
		System.out.println("Please choose an option: ");
	}
	public static void manageItemsMenu() {
		
	}
	public static void setBudget(Scanner scnr) {
		//TODO create a budget class in order to create different budget objects
		
		return;
	}
	public static void organizationOptionsMenu(Scanner scnr) {
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
			else{//else alert user of invalid input
				System.out.println("!INVALID INPUT!");//println
			}
		}while(!input.equalsIgnoreCase("r"));//do while input is not r or R
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
		 *a nested for loop will iterate through ArrayList multiple times to find matching itemTypes, each time it finds a matching itemType that index will be added to a new ArrayList
		 *old ArrayList will be scanned again and again until the new arrayList matches the size of the old ArrayList, this method will return the new ArrayList, replacing the old one.
		 *NOTE: it might be helpful to make an ArrayList for already encountered itemTypes so that way we can ignore already sorted itemTypes
		 */
		
		return;
	}
	public static double calculateTotal() {
		double total = 0.00;//initialize total with 0.00
		for(int i = 0 ; i < itemList.size(); ++i) {//for loop iterates through the size of itemList
			Item tempItem = itemList.get(i);//assign new object tempItem with object at i index of itemList
			total += tempItem.getItemTotal();//increment total by calling getItemTotal for tempItem
		}
		return total;//return the double total
	}
	public static void createItem(Scanner scnr) {
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
			scnr.next();//clear the scanner
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
			scnr.next();//clear the scanner
		}
		}while(!isValidInput);//do this while isValidInput is false
		itemList.add(newItem);//add object newItem to ArrayList itemList
		
		System.out.print("YOU ADDED: ");//readback
		newItem.printItemInfo();//call printItemInfo for object newItem
		
		scnr.nextLine();//clear the scanner
		return;
	}
	public static void printArrayList(Scanner scnr) {
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
		System.out.println("Total: " + calculateTotal());//println calls the calculate total method, to display total
		return;
	}
	
	public static void main(String[] args) {
		String input;//initialize String variable input
		
		do{//do while loop starts, branches will allow lowercase and uppercase
			printMainMenu();//always start by printing the main menu
			input = scnr.nextLine();//input is the nextLine
			if(input.equalsIgnoreCase("a")) {//if branch with ignorecase for option a
				createItem(scnr);//call createItem and pass the scnr
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
				System.out.println("Quitting");//printline to let user no program is terminating
			}
			else {
				System.out.println("!INVALID INPUT!");//else alert user of invalid input
			}
		}while(!input.equalsIgnoreCase("q"));//do this while input is not q
		scnr.close();//close the scanner
	}

}
