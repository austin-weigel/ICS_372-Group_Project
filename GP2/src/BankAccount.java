
public class BankAccount extends Donation implements Visitable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankAccount(String bankAccountNumber, double amount) {
		super(bankAccountNumber, amount);
	}

	public int getDonationValue() {
		return 0;
	}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
