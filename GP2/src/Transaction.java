
/**
 *
 * @author  Brodsky R, Schreifels J, Vang J, Weigel A
 *
 */
import java.io.Serializable;
import java.util.Date;

/**
 * A Transaction object that is made from a donation, copying the card number
 * and amount to donate. The Transaction also has a Date object recorded at time
 * of creation.
 *
 */
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;
	private long accountNumber;
	private double amount;
	private Date date;

	/**
	 * Transaction must be created from either a Donation or expense.
	 */
	private Transaction() {
	}

	public Transaction(Donation donation) {
		accountNumber = donation.getAccountNumber();
		amount = donation.getAmount();
		date = new Date();
	}

	/**
	 * Returns the credit card associated with the transaction
	 * 
	 * @return The credit card associated with the transaction
	 */
	public long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Returns the amount that was charged to the credit card at the time of the
	 * transaction
	 * 
	 * @return The amount charged to the credit card at the time of transaction
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * The time and date of when the transaction occured.
	 * 
	 * @return The time and date of when the transaction occured.
	 */
	public Date getDate() {
		return date;
	}
}
