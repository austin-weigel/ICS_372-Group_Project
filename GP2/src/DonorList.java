
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
 * This class makes use of MemberList by Dathan, and Ramnath adaptations and additions made by
 * @author Brodsky R, Schreifels J, Vang J, Weigel A
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A list of donors. Manages creations of donor IDs.
 *
 */
public class DonorList implements Iterable<Donor>, Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Donor> donors = new ArrayList<Donor>();
	private static DonorList donorList;

	/**
	 * Creates a new DonorList object with an initial ID of 0 that gets incremented
	 * at every addDonor. ID never gets decremented.
	 */
	private DonorList() {
	}

	/**
	 * Supports the singleton pattern
	 *
	 * @return the singleton object
	 */
	public static DonorList instance() {
		if (donorList == null) {
			return (donorList = new DonorList());
		} else {
			return donorList;
		}
	}

	/**
	 * Adds a donor to the donor list
	 *
	 * @param name  The name of the new donor
	 * @param phone The phone number of the new donor
	 * @return The integer generated as an ID for the donor.
	 */
	public boolean addDonor(Donor donor) {
		donors.add(donor);
		return true;
	}

	/**
	 * Removes a donor from the donor list
	 *
	 * @param donorID The ID of the donor to be removed.
	 * @return The donor who was removed or null if no donor had that ID.
	 */
	public Donor removeDonor(int donorID) {
		for (int i = 0; i < donors.size(); i++) {
			if (donors.get(i).getID() == donorID)
				return donors.remove(i);
		}
		return null;
	}

	/**
	 * Gets the donor with a given ID
	 *
	 * @param id The donor ID
	 * @return The donor with the given ID number or null if no Donor is found.
	 */
	public Donor getDonor(int id) {
		for (Donor donor : donors) {
			if (donor.getID() == id) {
				return donor;
			}
		}
		return null;
	}

	/**
	 * Iterates through the list of donors.
	 */
	@Override
	public Iterator<Donor> iterator() {
		return new DonorIterator();
	}

	/**
	 * Iterator for donors.
	 *
	 */
	private class DonorIterator implements Iterator<Donor> {

		int count; // The index of the current donor for the iterator.

		/**
		 * Starts the iterator at the begining of the donor list.
		 */
		DonorIterator() {
			count = 0;
		}

		@Override
		public Donor next() {
			if (hasNext())
				return donors.get(count++);
			return null;
		}

		@Override
		public boolean hasNext() {
			return count < donors.size();
		}
	}
}
