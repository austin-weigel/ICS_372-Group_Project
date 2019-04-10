import java.text.DecimalFormat;

/**
 * 
 * @author Joseph S
 *
 */
public class PaymentVisitor implements Visitor {

	private int threshold;
	DecimalFormat decimalFormat = new DecimalFormat("0.00");

	/**
	 * Constructs a PaymentVisitor object.
	 * 
	 * @param threshold The minimum amount a payment source must pay to be included.
	 */
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
}
