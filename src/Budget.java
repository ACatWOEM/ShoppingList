
public class Budget {
	//TODO build budget class in a way that will allow you to call on the budget in main to subtract the total of
	//all items from budget, create alarms for when 80% and 100% of budget are depleted.
	
	private double limit;

    public Budget(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public void checkBudgetStatus(double currentTotal) {
        double percentUsed = (currentTotal / limit) * 100;
        if (percentUsed >= 100) {
            System.out.println("!!! Budget fully used or exceeded! ($" + currentTotal + " / $" + limit + ")");
        } else if (percentUsed >= 80) {
            System.out.println("** Warning: 80% of budget used. ($" + currentTotal + " / $" + limit + ")");
        }
    }
	
	
}
