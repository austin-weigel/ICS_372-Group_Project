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

	@Override
	public void print() {
		System.out.print(accountNumber + "           ");
		System.out.printf("%10.2f", getAmount());
		System.out.println("     " + getDate());
	}

	@Override
	public String toString() {
		return accountNumber + " ";
	}
}