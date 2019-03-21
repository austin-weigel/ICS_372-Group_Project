import java.util.ArrayList;
import java.util.Iterator;

public class TransactionList implements Iterable<Transaction> {

	ArrayList<Transaction> transactions;

	public TransactionList() {
		transactions = new ArrayList<Transaction>();
	}

	public void addTransaction(Donation donation) {
		transactions.add(new Transaction(donation));
	}

	@Override
	public Iterator<Transaction> iterator() {
		return new TransactionIterator();
	}

	private class TransactionIterator implements Iterator<Transaction> {

		int count;

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
