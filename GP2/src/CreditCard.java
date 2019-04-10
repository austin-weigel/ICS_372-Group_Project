
public class CreditCard extends Donation implements Visitable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CreditCard(long cardNumber, double amount) {
		super(cardNumber, amount);
	}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
