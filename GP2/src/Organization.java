
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

/**
 * This class makes use of Library by Dathan, and Ramnath adaptations and additions made by 
 * @author Brodsky R, Schreifels J, Vang J, Weigel A
 */

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
	private DonorList donors;
	private static Organization organization;

	/**
	 * Creates a new Organization with an empty list of donors.
	 */
	public Organization() {
		donors = DonorList.instance();
	}

	/**
	 * Supports the singleton pattern
	 * 
	 * @return the singleton object
	 */
	public static Organization instance() {
		if (organization == null) {
			return (organization = new Organization());
		} else {
			return organization;
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
			ObjectInputStream input = new ObjectInputStream(file);
			organization = (Organization) input.readObject();
			DonorIDServer.retrieve(input);
			return organization;
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
			output.writeObject(organization);
			output.writeObject(DonorIDServer.instance());
			file.close();
			return true;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		}
	}

	/**
	 * Organizes the operations for adding a donor
	 * 
	 * @param name  donor name
	 * @param phone donor phone
	 * @return the Donor object created
	 */
	public Donor addDonor(String name, String phoneNumber) {
		Donor donor = new Donor(name, phoneNumber);
		if (donors.addDonor(donor)) {
			return donor;
		}
		return null;
	}

	/**
	 * Removes a credit card to the donor with the given ID
	 * 
	 * @param id         ID of the donor
	 * @param creditCard Credit card to be removed
	 */
	public void removeCreditCard(int id, long creditCard) {
		for (Donor donor : donors) {
			if (donor.getID() == id) {
				donor.getDonationList().removeDonation(creditCard);
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
		System.out.println();
	}

	/**
	 * Prints all transactions to the console.
	 */
	public void printTransactions() {
		System.out.println("Credit card          Amount    Date");
		for (Donor donor : donors) {
			for (Transaction transaction : donor.getTransactionList()) {

				System.out.printf("%016d", transaction.getAccountNumber());
				System.out.printf("%10.2f", transaction.getAmount());
				System.out.println("     " + transaction.getDate());
			}
		}
	}

	/**
	 * Returns a list of all donors in the system. [JJS]
	 * 
	 * @return The full donor list
	 */
	public DonorList getAllDonors() {
		return donors;
	}

	/**
	 * Returns a specific donor. [JJS]
	 * 
	 * @param donorId The Id of the donor to be returned
	 * @return The donor
	 */
	public Donor getDonor(int donorId) {
		return donors.getDonor(donorId);
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
