import java.util.Scanner;
import java.util.ArrayList;
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
	public static void organizationOptionsMenu() {
		System.out.println("-ORGANIZATION OPTIONS-");
		System.out.println("P - Organize by price");
		System.out.println("G - Organize by group");
		System.out.println("R - Return to menu");
		System.out.println("Please choose an option: ");
	}
	public static void setBudget(Scanner scnr) {
		//TODO create a budget class in order to create different budget objects
		
		return;
	}
	public static void displayList(Scanner scnr) {
		//TODO for loop running through "arrayOfItems" ArrayList and calling printItemInfo() for each index
		
		return;
	}
	public static void organizationOptions(Scanner scnr) {
		String input;
		
		do{
			organizationOptionsMenu();
			input = scnr.nextLine();
			if (input.equalsIgnoreCase("p")) {
				organizeByPrice(scnr);
			}
			else if(input.equalsIgnoreCase("g")) {
				organizeByGroup(scnr);
			}
			else{
				System.out.println("!INVALID INPUT!");
			}
		}while(!input.equalsIgnoreCase("r"));
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
		double total = 0.00;
		for(int i = 0 ; i < itemList.size(); ++i) {
			Item tempItem = itemList.get(i);
			total = total + tempItem.getItemPrice();
		}
		
		return total;
	}
	public static void createItem(Scanner scnr) {
		
		Item newItem = new Item();
		
		System.out.println("Please enter an item name:");
		newItem.setItemName(scnr.nextLine());
		System.out.println("Specify an item type:");
		newItem.setItemType(scnr.nextLine());
		System.out.println("Set an item price:");
		newItem.setItemPrice(scnr.nextDouble());
		System.out.println("Quantity of item:");
		newItem.setItemQuantity(scnr.nextInt());
		itemList.add(newItem);
		System.out.print("YOU ADDED: ");
		newItem.printItemInfo();
		scnr.nextLine();
		return;
	}
    
	public static void addToArrayList(Item newItem) {
		itemList.add(newItem);
		System.out.print("Item added: ");
		newItem.printItemInfo();
		return;
	}
	
	public static void printArrayList(Scanner scnr) {
		int count = 0;
		for(int i = 0 ; i < itemList.size(); i++) {
			Item tempItem = itemList.get(i);
			tempItem.printItemInfo();
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
		System.out.println("Total: " + calculateTotal());
		return;
	}
	
	public static void main(String[] args) {
		String input;
		
		do{
			printMainMenu();
			input = scnr.nextLine();
			if(input.equalsIgnoreCase("a")) {
				createItem(scnr);
			}
			else if(input.equalsIgnoreCase("b")) {
				setBudget(scnr);
			}
			else if(input.equalsIgnoreCase("d")) {
				printArrayList(scnr);
			}
			else if(input.equalsIgnoreCase("o")) {
				organizationOptions(scnr);
			}
			else if(input.equalsIgnoreCase("t")) {
				calculateTotal();
			}
			else if(input.equalsIgnoreCase("q")) {
				System.out.println("Quitting");
			}
			else {
				System.out.println("!INVALID INPUT!");
			}
		}while(!input.equalsIgnoreCase("q"));
		scnr.close();
	}

}
