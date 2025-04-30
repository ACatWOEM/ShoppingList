import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	
	static ArrayList<item> itemList = new ArrayList<item>();
	
	public static void printMenu() {
		System.out.println("-MENU-");
		System.out.println("A - add Item");// in the future open "manage items" options to add item, remove item, search items, etc.
		System.out.println("B - set Budget");
		System.out.println("D - Display List and remaining budget");
		System.out.println("O - Organization options");
		System.out.println("T - Calculate total + tax");
		System.out.println("Q - Quit");
		System.out.println("Please choose an option: ");
	}
	public static void menu(Scanner scnr) {
		printMenu();
		String input;
		Character choice;
		
		do {
			input = scnr.nextLine();
			choice = input.charAt(0);
			
			//FIXME q needs to be entered a variable number of times before terminating the program
			
			if(choice.equals('a') || choice.equals('A')) {
				createItem(scnr);
			}
			else if(choice.equals('b') || choice.equals('B')) {
				setBudget(scnr);
			}
			else if(choice.equals('d') || choice.equals('D')) {
				printArrayList(scnr);
			}
			else if(choice.equals('o') || choice.equals('O')) {
				organizationOptions(scnr);
			}
			else if(choice.equals('t') || choice.equals('T')) {
				calculateTotal(scnr);
			}
			else if(choice.equals('q') || choice.equals('Q')){
				break;
			}
			else {
				System.out.println("Please enter a valid option: ");
			}
		}while((!choice.equals('q')) && (!choice.equals('Q')));
		
		scnr.nextLine();
	}
	public static void setBudget(Scanner scnr) {
		//TODO create a budget class in order to create different budget objects
		
		menu(scnr);
	}
	public static void displayList(Scanner scnr) {
		//TODO for loop running through "arrayOfItems" ArrayList and calling printItemInfo() for each index
		
		menu(scnr);
	}
	public static void organizationOptions(Scanner scnr) {
		System.out.println("-ORGANIZATION OPTIONS-");
		System.out.println("P - Organize by price");
		System.out.println("G - Organize by group");
		System.out.println("R - Return to menu");
		System.out.println("Please choose an option: ");
		
		String input = scnr.nextLine();
		Character choice = input.charAt(0);
		
		while((!choice.equals('r') && (!choice.equals('R')))) {
			if (choice.equals('p') || choice.equals('P')) {
				organizeByPrice(scnr);
			}
			else if(choice.equals('g') || choice.equals('G')) {
				organizeByGroup(scnr);
			}
			else{
				System.out.println("Please enter a valid option: ");
			}
			input = scnr.nextLine();
			choice = input.charAt(0);
		}
		menu(scnr);
		return;
	}
	public static void organizeByPrice(Scanner scnr) {
		/*
		 * TODO for loop with if else if branches for whether or not a price at index i is higher or lower than the the former index, deciding 
		 * which way to push object in index (up or down)this might be a nested for loop to ensure that every price is properly sorted
		 */
	
		menu(scnr);
	}
	public static void organizeByGroup(Scanner scnr) {
		/*
		 *a nested for loop will iterate through ArrayList multiple times to find matching itemTypes, each time it finds a matching itemType that index will be added to a new ArrayList
		 *old ArrayList will be scanned again and again until the new arrayList matches the size of the old ArrayList, this method will return the new ArrayList, replacing the old one.
		 *NOTE: it might be helpful to make an ArrayList for already encountered itemTypes so that way we can ignore already sorted itemTypes
		 */
		
		menu(scnr);
	}
	public static void calculateTotal(Scanner scnr) {
		/*
		 * TODO simply calculating the total of each item, for loop, int tempValue *= arraylist.get(i) // EDIT: might be deceptively challenging
		 */
		
		menu(scnr);
	}
	public static void createItem(Scanner scnr) {
		
		item newItem = new item();
		
		System.out.println("Please enter an item name:");
		String itemName = scnr.nextLine();
		newItem.setItemName(itemName);
		System.out.println("confirm entry: " + newItem.getItemName());
		
		System.out.println("Specify an item type:");
		String itemType = scnr.nextLine();
		newItem.setItemType(itemType);
		System.out.println("confirm entry: " + newItem.getItemType());
		
		System.out.println("Set an item price:");
		double itemPrice = scnr.nextDouble();
		newItem.setItemPrice(itemPrice);
		System.out.println("confirm entry: " + newItem.getItemPrice());
		
		System.out.println("Quantity of item:");
		int itemQuantity = scnr.nextInt();
		newItem.setItemQuantity(itemQuantity);
		System.out.println("confirm entry: " + newItem.getItemQuantity());

		itemList.add(newItem);
		scnr.nextLine();
		menu(scnr);
	}
    
	public static void addToArrayList(Scanner scnr,item newItem) {
		ArrayList<item> arrayOfItems = new ArrayList<item>();
		arrayOfItems.add(newItem);
		System.out.print("Item added: ");
		newItem.printItemInfo();
	}
	
	public static void printArrayList(Scanner scnr) {
		int count = 0;
		for(int i = 0 ; i < itemList.size(); i++) {
			item newItem = itemList.get(i);
			newItem.printItemInfo();
			++count;
		}
		if(count > 1) {
			System.out.println(count + " items on list");
		}
		else if(count == 1) {
			System.out.println(count + " item on list");
		}
		else {
			System.out.println("No items on list");
		}
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		menu(scnr);
		
		scnr.close();
	}

}
