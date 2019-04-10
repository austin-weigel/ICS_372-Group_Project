import java.text.DecimalFormat;

public class PaymentVisitor implements Visitor {

	int threshold;
	DecimalFormat decimalFormat = new DecimalFormat("0.00");

	public PaymentVisitor(int threshold) {
		this.threshold = threshold;
	}

	@Override
	public String visit(Donation item) {
		if (item.getAmount() >= threshold)
			return "Account type: " + getAccountType(item) + ". Number of associated transactions: " + item.getTally()
					+ ". Donation amount: $" + decimalFormat.format(item.getAmount());

		return "";
	}

	public String getAccountType(Donation item) {
		return (item.getRoutingNumber() == 0) ? "Credit Card" : "Bank Account";
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

}
