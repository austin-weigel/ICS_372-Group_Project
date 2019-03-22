import java.io.Serializable;

/**
 * A Donations is a credit card and an amount. Once the donations has been made
 * it can not be changed.
 * 
 * @author Austin Weigel
 *
 */
public class Donation implements Serializable {

	private static final long serialVersionUID = 1L;
	private int creditCard; // The credit card to be charged.
	private double amount; // The amount to charge to the credit card.

	/**
	 * Creates a new donations. Credit card number and amount must be given at
	 * construction of class.
	 * 
	 * @param creditCard The credit card number to charge the donation amount to.
	 * @param amount     The amount to be charged to the credit card.
	 */
	Donation(int creditCard, double amount) {
		this.creditCard = creditCard;
		this.amount = amount;
	}

	/**
	 * Returns the credit card that will be charged.
	 * 
	 * @return The credit card that will be charged.
	 */
	int getCreditCard() {
		return creditCard;
	}

	/**
	 * Returns the amount that will be charged to the credit card.
	 * 
	 * @return The amount that will be charged to the credit card.
	 */
	double getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + creditCard;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Donation other = (Donation) obj;
		if (creditCard != other.creditCard)
			return false;
		return true;
	}
}