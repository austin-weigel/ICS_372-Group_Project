/**
 * Class to store and implement income information
 * 
 * @author Brodsky R, Schreifels J, Vang J, Weigel A
 *
 */
public class Income extends Transaction {

	private static final long serialVersionUID = 1L;
	private long accountNumber;

	public Income(Donation donation) {
		super(donation.getAmount());
		accountNumber = donation.getAccountNumber();
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
	 * method to print and override the transactions print() to display the
	 * correction transactions type
	 */
	@Override
	public void print() {
		System.out.print(accountNumber + "           ");
		System.out.printf("%10.2f", getAmount());
		System.out.println("     " + getDate());
	}

	/**
	 * Converting accountNumber to String
	 */
	@Override
	public String toString() {
		return accountNumber + " ";
	}
}