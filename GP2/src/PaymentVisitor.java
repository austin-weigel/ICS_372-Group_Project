
public class PaymentVisitor implements Visitor {

	int threshold;

	public PaymentVisitor(int threshold) {
		this.threshold = threshold;
	}

	@Override
	public String visit(CreditCard item) {
		if (item.getAmount() >= threshold)
			return "Account type: Credit Card. Number of associated transactions: " + item.getTally()
					+ ". Total amount donated: " + item.getAmount() + ".";

		return "";
	}

	@Override
	public String visit(BankAccount item) {
		if (item.getAmount() >= threshold)
			return "Account type: Bank Account. Number of associated transactions: " + item.getTally()
					+ ". Total amount donated: " + item.getAmount() + ".";

		return "";
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

}
