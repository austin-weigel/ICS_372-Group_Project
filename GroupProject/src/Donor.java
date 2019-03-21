
public class Donor {
	int id;
	String name;
	int phoneNumber;
	DonationList donations;
	TransactionList transactions;

	/**
	 * Creates a new donor with no donations or transaction history.
	 * 
	 * @param name        The name of the new donor.
	 * @param phoneNumber The phone number of the donor.
	 */
	public Donor(String name, int phoneNumber, int id) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		donations = new DonationList();
		transactions = new TransactionList();
	}

	public String getName() {
		return name;
	}

	public int getPhone() {
		return phoneNumber;
	}

	public int getID() {
		return id;
	}

	public DonationList getDonationList() {
		return donations;
	}

	public TransactionList getTransactionList() {
		return transactions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Donor other = (Donor) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
