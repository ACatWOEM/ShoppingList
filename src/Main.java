import java.util.Scanner;
public class Main {
	public static void displayMenu(Scanner scnr) {
		System.out.println("-MENU-");
		System.out.println("A - add Item");
		System.out.println("B - set Budget");
		System.out.println("D - Display List and remaining budget");
		System.out.println("O - Organization options");
		System.out.println("T - Calculate total + tax");
		System.out.println("Q - Quit");
		System.out.println("Please choose an option: ");
		executeMenu(scnr);
	}
	public static void executeMenu(Scanner scnr) {
		String input;
		Character choice;

		do {
			input = scnr.nextLine();
			choice = input.charAt(0);
			if(choice.equals('a') || choice.equals('A')) {
				createItem(scnr);
			}
			else if(choice.equals('b') || choice.equals('B')) {
				setBudget(scnr);
			}
			else if(choice.equals('d') || choice.equals('D')) {
				displayList(scnr);
			}
			else if(choice.equals('o') || choice.equals('O')) {
				organizationOptions(scnr);
			}
			else if(choice.equals('t') || choice.equals('T')) {
				calculateTotal(scnr);
			}
			else {
				System.out.println("Please choose a valid option: ");
			}

		}while((!choice.equals('q')) && (!choice.equals('Q')));
		return;
	}
	public static void setBudget(Scanner scnr) {
		
		displayMenu(scnr);
	}
	public static void displayList(Scanner scnr) {
		
		displayMenu(scnr);
	}
	public static void organizationOptions(Scanner scnr) {
		Character choice;
		String input;
		
		System.out.println("-ORGANIZATION OPTIONS-");
		System.out.println("P - Organize by price");
		System.out.println("G - Organize by group");
		System.out.println("R - Return to menu");
		System.out.println("Please choose an option: ");
		
		input = scnr.nextLine();
		choice = input.charAt(0);
		do {
			if (choice.equals('p')) {
				organizeByPrice(scnr);
			}
			else if(choice.equals('g')) {
				organizeByGroup(scnr);
			}
			else{
				System.out.println("Please enter a valid option: ");
			}
		} while ((!choice.equals('r') && (!choice.equals('R'))));
		displayMenu(scnr);
	}
	public static void organizeByPrice(Scanner scnr) {
	
		displayMenu(scnr);
	}
	public static void organizeByGroup(Scanner scnr) {
		
		displayMenu(scnr);
	}
	public static void calculateTotal(Scanner scnr) {
		
		displayMenu(scnr);
	}
	public static void createItem(Scanner scnr) {
		item item = new item();
		
		System.out.println("Please enter an item name:");
		String itemName = scnr.nextLine();
		setItemName(itemName);
		
		System.out.println("Specify an item type:");
		String itemType = scnr.nextLine();
		setItemType(itemType);
		
		System.out.println("Set an item price:");
		double itemPrice = scnr.nextDouble();
		
		System.out.println("Quantity of item:");
		int itemQuantity = scnr.nextInt();
		
		
		addNewItemToArray();
		displayMenu(scnr);
	}
	public static void addNewItemToArray () {
		
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		displayMenu(scnr);
		
		scnr.close();
	}

}
