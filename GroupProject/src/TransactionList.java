import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A list of all transactions given by some donor.
 *
 */
public class TransactionList implements Iterable<Transaction>, Serializable {

	private static final long serialVersionUID = 1L;
	ArrayList<Transaction> transactions; // The list of transactions

	/**
	 * Creates an empty list of transactions.
	 */
	public TransactionList() {
		transactions = new ArrayList<Transaction>();
	}

	/**
	 * Adds a transaction to the list of transactions.
	 * 
	 * @param donation
	 *            The donations which gives the credit card and amount for the
	 *            transaction.
	 */
	public void addTransaction(Donation donation) {
		transactions.add(new Transaction(donation));
	}

	@Override
	public Iterator<Transaction> iterator() {
		return new TransactionIterator();
	}

	/**
	 * Creates an iterator over all the transactions in the TransactionList.
	 *
	 */
	private class TransactionIterator implements Iterator<Transaction> {

		int count;

		/**
		 * Creates a new iterator over all the transactions, starting at the
		 * transactions at index 0.
		 */
		public TransactionIterator() {
			count = 0;
		}

		@Override
		public Transaction next() {
			if (hasNext())
				return transactions.get(count++);
			return null;
		}

		@Override
		public boolean hasNext() {
			return (count < transactions.size());
		}
	}
}
