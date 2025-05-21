
public class Budget {
	//TODO build budget class in a way that will allow you to call on the budget in main to subtract the total of
	//all items from budget, create alarms for when 80% and 100% of budget are depleted.
	
	private double income;
    private String payFrequency;
    private double monthlyBudget;
    private double currentSpent;

    public Budget(double income, String payFrequency) {
        this.income = income;
        this.payFrequency = payFrequency.toLowerCase();
        this.monthlyBudget = calculateMonthlyBudget();
        this.currentSpent = 0;
    }

    private double calculateMonthlyBudget() {
        switch (payFrequency) {
            case "weekly":
                return income * 4; // weeks per month
            case "biweekly":
                return income * 2; // biweekly periods in a month
            case "monthly":
                return income;
            case "salary":
                return income / 12; // annual salary divided by 12
            default:
                System.out.println("Invalid pay frequency. Defaulting to monthly.");
                return income;
        }
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public double getCurrentSpent() {
        return currentSpent;
    }

    public void addSpending(double amount) {
        currentSpent += amount;
        checkBudgetStatus();
    }

    // Reset monthly spending (for a new month)
    public void resetMonthlySpending() {
        currentSpent = 0;
    }

    // trigger alerts
    public void checkBudgetStatus() {
        double percentUsed = (currentSpent / monthlyBudget) * 100;
        if (percentUsed >= 100) {
            System.out.println("!!! Budget fully used or exceeded! ($" + currentSpent + " / $" + monthlyBudget + ")");
        } else if (percentUsed >= 80) {
            System.out.println("** Warning: 80% of budget used. ($" + currentSpent + " / $" + monthlyBudget + ")");
        } else {
            System.out.println("Budget OK: $" + currentSpent + " out of $" + monthlyBudget);
        }
    }
}
	
