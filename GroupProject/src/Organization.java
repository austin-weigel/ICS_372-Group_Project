import java.io.Serializable;

/**
 * An organization object that contains the methods for all use cases called by
 * the Interface.
 *
 */
public class Organization implements Serializable {

	private static final long serialVersionUID = 1L;
	DonorList donors;

	/**
	 * Creates a new Organization with an empty list of donors.
	 */
	public Organization() {
		donors = new DonorList();
	}

	/**
	 * Creates a new donor with the total number of existing donors being the new
	 * donor's id.
	 * 
	 * @param name        The name of the new donor
	 * @param phoneNumber The phone number of the new donor.
	 */
	public int addDonor(String name, int phoneNumber) {
		return donors.addDonor(name, phoneNumber);
	}

	/**
	 * Adds a credit card to the donor with the given ID
	 * 
	 * @param id         The ID of the donor to add the credit card to.
	 * @param creditCard The number of the credit card.
	 * @param amount     The amount to charge the credit card on each transaction.
	 */
	public void addCreditCard(int id, int creditCard, double amount) {
		for (Donor donor : donors) {
			if (donor.getID() == id) {
				donor.getDonationList().addDonation(creditCard, amount);
				return;
			}
		}
	}

	/**
	 * Creates a transaction for every donation. Prints the total amount of
	 * donations collected.
	 */
	public void processDonations() {
		double total = 0;
		for (Donor donor : donors) {
			for (Donation donation : donor.getDonationList()) {
				donor.getTransactionList().addTransaction(donation);
				total += donation.getAmount();
			}
		}
		System.out.print("Total amount in donations: $");
		System.out.format("%10.2f", total);
	}

	/**
	 * Prints all transactions to the console.
	 */
	public void printTransactions() {
		System.out.println("Credit card Amount Date");
		for (Donor donor : donors) {
			for (Transaction transaction : donor.getTransactionList()) {
				System.out.format("%016d%n", transaction.getCreditCard());
				System.out.format("%10.2f%n", transaction.getAmount());
				System.out.println(transaction.getDate());
			}
		}
	}

	/**
	 * Removes a donor from the organization
	 * 
	 * @param id The id of the donor to remove
	 * @return The donor who was removed.
	 */
	public Donor removeDonor(int id) {
		return donors.removeDonor(id);
	}
}
