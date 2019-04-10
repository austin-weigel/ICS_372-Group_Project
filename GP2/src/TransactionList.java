
/**
 *
 * @author  Brodsky R, Schreifels J, Vang J, Weigel A
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Container class for the Transaction object
 */
public class TransactionList implements Iterable<Transaction>, Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	private static TransactionList transactionList;

	/**
	 * Creates an empty list of transactions.
	 */
	private TransactionList() {
	}

	/**
	 * Supports the singleton pattern
	 *
	 * @return the singleton object
	 */
	public static TransactionList instance() {
		if (transactionList == null) {
			return (transactionList = new TransactionList());
		} else {
			return transactionList;
		}
	}

	/**
	 * Adds a transaction to the list of transactions.
	 * 
	 * @param donation The donations which gives the credit card and amount for the
	 *                 transaction.
	 */
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public double getTotal() {
		double total = 0;
		for (Transaction transaction : transactions) {
			total += transaction.getAmount();
		}
		return total;
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
