
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
	private double amount;
	private Date date;

	/**
	 * Transaction must be created from either a Donation or expense.
	 */
	public Transaction(double amount) {
		this.amount = amount;
		date = new Date();
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

	public void print() {
		System.out.printf("%10.2f", getAmount());
		System.out.println("     " + getDate());
	}

	@Override
	public String toString() {
		return amount + " " + date + " ";
	}

}
