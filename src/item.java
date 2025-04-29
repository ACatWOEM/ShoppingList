
public class item {
	private String itemName = "no name";
	private String itemType = "no type";
	private double itemPrice = 0.00;
	private int itemQuantity = 0;
	private double itemTotal = 0.00;

	public void setItemName(String itemName) {//setter for itemName
		System.out.println("Please enter an item name:");
		this.itemName = itemName;
	}
	public void setItemType(String itemType) {//setter for itemType
		System.out.println("Specify an item type:");
		this.itemType = itemType;
	}
	public void setItemPrice(double itemPrice) {//setter for itemPrice
		System.out.println("Set an item price:");
		this.itemPrice = itemPrice;
	}
	public void setItemQuantity(int itemQuantity) {
		System.out.println("Quantity of item:");
		this.itemQuantity = itemQuantity;
	}
	public String getItemName() {//getter for itemName
		return itemName;
	}
	public String getItemType() {//getter for itemType
		return itemType;
	}
	public double getItemPrice() {//getter for itemPrice
		return itemPrice;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public double getItemTotal() {
		itemTotal = itemPrice * itemQuantity;
		return itemTotal;
	}
	public void printItemInfo() {//getter for printing the information about an item
		System.out.println(getItemQuantity() + " " + getItemName() + "'s @ $" + getItemPrice() + "is $" + getItemTotal() + " total");
	}
}
