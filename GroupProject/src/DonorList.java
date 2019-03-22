import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A list of donors. Manages creations of donor IDs.
 *
 */
public class DonorList implements Iterable<Donor>, Serializable {

	private static final long serialVersionUID = 1L;
	public ArrayList<Donor> donors;
	int idCount;

	/**
	 * Creates a new DonorList object with an initial ID of 0 that gets incremented
	 * at every addDonor. ID never gets decremented.
	 */
	public DonorList() {
		donors = new ArrayList<Donor>();
		idCount = 0;
	}

	/**
	 * Adds a donor to the donor list
	 * 
	 * @param name  The name of the new donor
	 * @param phone The phone number of the new donor
	 * @return The integer generated as an ID for the donor.
	 */
	public int addDonor(String name, int phone) {
		donors.add(new Donor(name, phone, idCount++));
		return donors.size() - 1;
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
	 * @param id The ID of the donor
	 * @return The donor with the given ID number or null if no Donor was found with
	 *         that ID.
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
				return donors.get(count);
			return null;
		}

		@Override
		public boolean hasNext() {
			return count < donors.size();
		}
	}
}
