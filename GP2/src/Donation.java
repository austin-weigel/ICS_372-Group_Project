
/**
 * @author Brodsky R, Schreifels J, Vang J, Weigel A
 */

import java.io.Serializable;

/**
 * A Donations is a credit card and an amount. Once the donations has been made
 * it can not be changed.
 * 
 * 
 *
 */
public class Donation implements Serializable {

	private static final long serialVersionUID = 1L;
	private long accountNumber;
	private double amount; // The amount to charge to the credit card.

	/**
	 * Creates a new donations. Credit card number and amount must be given at
	 * construction of class.
	 * 
	 * @param creditCard The credit card number to charge the donation amount to.
	 * @param amount     The amount to be charged to the credit card.
	 */
	public Donation(long accountNumber, double amount) {
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	/**
	 * Returns the credit card that will be charged.
	 * 
	 * @return The credit card that will be charged.
	 */
	public long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Returns the amount that will be charged to the credit card.
	 * 
	 * @return The amount that will be charged to the credit card.
	 */
	public double getAmount() {
		return amount;
	}
}