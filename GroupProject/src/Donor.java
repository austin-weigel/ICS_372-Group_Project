
/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */

import java.io.Serializable;

/**
 * 
 * A donor or someone who has promised 0-many donations and has 0-many
 * transactions.
 *
 */
public class Donor implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id; // The id of the donor.
	private String name; // The name of the donor.
	private String phoneNumber; // The phone number of the donor.
	private DonationList donations = new DonationList(); // The list of
															// donations
															// promised by the
															// donor.
	private TransactionList transactions = new TransactionList(); // The list of
																	// completed
																	// transactions
																	// from the
																	// donor

	/**
	 * Creates a new donor with no donations or transaction history.
	 * 
	 * @param name
	 *            The name of the new donor.
	 * @param phoneNumber
	 *            The phone number of the donor.
	 */
	public Donor(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		id = DonorIDServer.instance().getId();
	}

	/**
	 * Returns the name of the donor.
	 * 
	 * @return The name of the donor.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the phone number of the donor.
	 * 
	 * @return the phone number of the donor.
	 */
	public String getPhone() {
		return phoneNumber;
	}

	/**
	 * Gets the ID of the donor.
	 * 
	 * @return The ID of the donor.
	 */
	public int getID() {
		return id;
	}

	public void addDonation(Donation donation) {
		donations.addDonation(donation);
	}

	/**
	 * Gets the list of donations, which is a credit card and amount, for that
	 * donor.
	 * 
	 * @return
	 */
	public DonationList getDonationList() {
		return donations;
	}

	/**
	 * Gets a list of all transactions by that donor.
	 * 
	 * @return The list of all transactions by that donor
	 */
	public TransactionList getTransactionList() {
		return transactions;
	}

	/**
	 * Overrides the toString method. Prints all donor info (except credit card
	 * info)
	 */
	@Override
	public String toString() {
		return "Donor: Name " + name + ", Phone " + phoneNumber + ", ID " + id;
	}

	/**
	 * Return all donor information including credit cards [JJS]
	 * 
	 * @return Donor information including credit cards
	 */
	public String getAllDonorInfo() {
		// Get the standard donor information
		String output = toString() + ",";
		double sumOfCreditCards = 0;

		// Output all credit cards and keep track of total value of those cards
		for (Donation item : donations) {
			output += " Card number " + item.getCreditCard() + ",";
			sumOfCreditCards += item.getAmount();
		}

		// Add the total value of the cards to the output
		output += " Total donations per cycle " + sumOfCreditCards;

		return output;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Donor other = (Donor) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
