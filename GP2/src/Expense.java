/**
 * 
 * @author Brodsky R, Schreifels J, Vang J, Weigel A
 *
 */
public class Expense extends Transaction {
	private String type;
	private static final long serialVersionUID = 1L;

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

	@Override
	public String toString() {
		return type;
	}
}
