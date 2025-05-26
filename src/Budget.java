import java.util.InputMismatchException;
import java.util.Scanner;
public class Budget{
	private double income;
	private int payFrequency;
	private double monthlyPay;
	private int percentage;
	private double budget;
	
	public void setIncome(Scanner scnr) {
		try {
		income = scnr.nextDouble();
		}
		catch(InputMismatchException e) {
			System.out.println("Please use numbers");
			scnr.next();
			System.out.println("Enter income: ");
			setIncome(scnr);
		}
	}
	public void setPayFrequency(Scanner scnr) {
		scnr.nextLine();
		char freq;
		do {
			String input = scnr.nextLine();
			input.toLowerCase();
			freq = input.charAt(0);
			if(freq == 'w') {
				this.payFrequency = 4;
			}
			else if(freq == 'b') {
				this.payFrequency = 2;
			}
			else if(freq == 'm') {
				this.payFrequency = 1;
			}
			else if(freq == 's') {
				this.payFrequency = 12;
			}
			else {
				System.out.print("Please enter a valid input: ");
			}
		}while(freq != 'w' && freq != 'b' && freq != 'm' && freq != 's');
		setMonthlyPay();
	}
	public void setMonthlyPay() {
		if(payFrequency == 4 || payFrequency == 2 || payFrequency == 1) {
			monthlyPay = (income * payFrequency);
		}
		else if(payFrequency == 12) {
			monthlyPay = (income / payFrequency);
		}
		else {
			System.out.print("type shit");
		}
	}
	public void setPercentage(Scanner scnr) {
		try {
		this.percentage = scnr.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("Please use whole numbers");
			scnr.next();
			System.out.println("Enter percentage of monthly pay for budget: ");
			setPercentage(scnr);
		}
	}
	public void calculateBudget() {
		budget = (percentage * monthlyPay) / 100;
	}
	public void setBudget(Double fromFileScan) {
		budget = fromFileScan;
	}
	public double getIncome() {
		return income;
	}
	public double getMonthlyPay() {
		return monthlyPay;
	}
	public double getBudget() {
		return budget;
	}
	public void checkBudget(double total) {
		if(total > budget) {
			System.out.println("!WARNING!"+"\n"+"BUDGET EXCEEDED");
			return;
		}
		else if(total > (20 * budget)/100) {
			System.out.print("Warning, approaching budget limit, ");
			System.out.printf("%.2f", (budget - total));
			System.out.println(" remains.");
			return;
		}
	}
}