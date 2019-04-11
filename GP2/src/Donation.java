
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
public class Donation implements Serializable, Visitable {

	private static final long serialVersionUID = 1L;
	private long accountNumber;
	private long routingNumber;

	private double amount; // The amount to charge to the credit card.
	private int tally = 0;

	/**
	 * Creates a new donations. Credit card number and amount must be given at
	 * construction of class.
	 *
	 * @param THe    creditCard number or bank account number to charge the donation
	 *               amount to.
	 * @param amount The amount to be charged to the credit card.
	 */
	public Donation(long accountNumber, double amount) {
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	/**
	 * Creates a new donation that is the type bank account
	 * 
	 * @param accountNumber
	 * @param routingNumber
	 * @param amount
	 */
	public Donation(long accountNumber, long routingNumber, double amount) {
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.amount = amount;
	}

	/**
	 * Returns the credit card/ bank account that will be charged.
	 *
	 * @return The credit card/ bank account that will be charged.
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

	/**
	 * Track of how many transactions this donation has been involved with. [JJS]
	 */
	public void incrementTally() {
		tally++;
	}

	/**
	 * Get the number of transactions this donation has been involved with. [JJS]
	 * 
	 * @return The tally.
	 */
	public int getTally() {
		return tally;
	}

	@Override
	public String toString() {
		return "Donation: payment method number is " + accountNumber + "\nif it is a bank account the routingNumber is "
				+ routingNumber + "\nwith a donation amout of " + amount;
	}

	/**
	 * Implementation of Visitable interface. Uses the visitor pattern to get
	 * information for the appropriate payment type. [JJS]
	 * 
	 * @return Information for the appropriate payment type.
	 */
	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public long getRoutingNumber() {
		return routingNumber;
	}
}