import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * An organization object that contains the methods for all use cases called by
 * the Interface.
 *
 */
public class Organization implements Serializable {

	private static final long serialVersionUID = 1L;
	DonorList donors;
	private static Organization org;
	private static ObjectInputStream input;

	/**
	 * Creates a new Organization with an empty list of donors.
	 */
	public Organization() {
		donors = new DonorList.instance();
	}

	/**
	 * Supports the singleton pattern
	 * 
	 * @return the singleton object
	 */
	public static Organization instance() {
		if (org == null) {
			return (org = new Organization());
		} else {
			return org;
		}
	}

	/**
	 * Retrieves a deserialized version of the library from disk
	 * 
	 * @return a Library object
	 */
	public static Organization retrieve() {
		try {
			FileInputStream file = new FileInputStream("OrganizationData");
			input = new ObjectInputStream(file);
			org = (Organization) input.readObject();
			return org;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		}
	}

	/**
	 * Serializes the Library object
	 * 
	 * @return true iff the data could be saved
	 */
	public static boolean save() {
		try {
			FileOutputStream file = new FileOutputStream("OrganizationData");
			ObjectOutputStream output = new ObjectOutputStream(file);
			output.writeObject(org);
			output.writeObject(donors);
			file.close();
			return true;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		}
	}

	/**
	 * Creates a new donor with the total number of existing donors being the new
	 * donor's id.
	 * 
	 * @param name        The name of the new donor
	 * @param phoneNumber The phone number of the new donor.
	 */
	public Donor addDonor(String name, String phoneNumber) {
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
	 * Prints a list of all donors. Each donor gets it's own line
	 */
	public void printDonors() {
		for (Donor donor : donors) {
			System.out.println(donor);
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
