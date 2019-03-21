import java.util.ArrayList;
import java.util.Iterator;

/**
 * Container class for Donations for each donor.
 * 
 * @author Austin Weigel
 *
 */
public class DonationList implements Iterable<Donation> {

	private ArrayList<Donation> donations;		//A list of all the donations

	/**
	 * Creates a new list of donations initially empty.
	 */
	public DonationList() {
		donations = new ArrayList<Donation>();
	}

	/**
	 * Adds a donation to the donations list
	 * @param creditCard The number of the credit card to be added
	 * @param amount The amount to be charged to the credit card. 
	 */
	public void addDonation(int creditCard, double amount) {
		donations.add(new Donation(creditCard, amount));
	}

	/**
	 * Removes the first donation in the donations list with a matching credit card number.
	 * @param creditCard The number of the credit card to remove. 
	 */
	public void removeDonation(int creditCard) {
		donations.remove(new Donation(creditCard, 0));
	}

	@Override
	public Iterator<Donation> iterator() {
		return new DonationsIterator();
	}
	
	private class DonationsIterator implements Iterator<Donation>{
		int counter;
		
		DonationsIterator(){
			counter = 0;
		}
		
		public Donation next(){
			if(hasNext())
				return donations.get(counter++);
			return null;
		}
		
		public boolean hasNext() {
			return counter < donations.size();
		}
	}
}
