
public class BankAccount extends Donation implements Visitable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BankAccount(long bankAccountNumber, long routingNumber, double amount) {
		super(bankAccountNumber, routingNumber, amount);
	}

	public int getDonationValue() {
		return 0;
	}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
