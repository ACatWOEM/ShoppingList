// TODO READ ABOUT import java.math.BigDecimal;

public class Item {
	private String itemName = "no name";
	private String itemType = "no type";
	private double itemPrice = 0.00;
	private int itemQuantity = 0;
	private double itemTotal = 0.00;

	public void setItemName(String itemName) {//setter for itemName
		this.itemName = itemName;
	}
	public void setItemType(String itemType) {//setter for itemType
		this.itemType = itemType;
	}
	public void setItemPrice(double itemPrice) {//setter for itemPrice
		this.itemPrice = itemPrice;
	}
	public void setItemQuantity(int itemQuantity) {
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
	public int getItemQuantity() {//getter for itemQuantity
		return itemQuantity;
	}
	public double getItemTotal() {//getter price and quantity, calculate total
		itemTotal = itemPrice * itemQuantity;
		return itemTotal;
	}
	public void printItemInfo() {//getter for printing the information about an item
		if(getItemQuantity() == 1) {
			System.out.print(getItemQuantity() + " " + getItemName() + " @ $"); //one name at a price
			System.out.printf("%.2f", getItemPrice());//formatting for hundredth decimal always
			System.out.print(" is $");//is total
			System.out.printf("%.2f\n", getItemTotal());//formatting for hundredth decimal always
		}
		else {
			System.out.print(getItemQuantity() + " " + getItemName() + "'s @ $"); //quantity name's at a price
			System.out.printf("%.2f", getItemPrice());//formatting for hundredth decimal always
			System.out.print(" is $");//is total
			System.out.printf("%.2f\n", getItemTotal());//formatting for hundredth decimal always
		}
	}
}
