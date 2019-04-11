
public class Expense extends Transaction {
	String type;

	public Expense(double amount, String type) {
		super(amount * -1);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	@Override
	public void print() {
		System.out.printf("%10.2f", getAmount());
		System.out.println("     " + getDate() + "     " + getType());
	}
}
