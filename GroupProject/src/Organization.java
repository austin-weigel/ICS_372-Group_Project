public class Organization {

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

	public double processDonations() {
		double total = 0;
		for (Donor donor : donors) {
			for (Donation donation : donor.getDonationList()) {
				donor.getTransactionList().addTransaction(donation);
				total += donation.getAmount();
			}
		}
		return total;
	}

	public String listTransactions() {
		String res = "";
		for (Donor donor : donors) {
			for (Transaction transaction : donor.getTransactionList()) {
				// todo
			}
		}
		return res;
	}
}
