
public class PaymentVisitor implements Visitor {

	int threshold = 1;

	public PaymentVisitor() {
	}

	@Override
	public String visit(CreditCard item) {
		if (item.getDonationValue() < threshold)
			return "Account type: " + 1 + " Number of associated transactions: " + 1 + " Total amount donated: "
					+ item.getDonationValue();

		return "";
	}

	@Override
	public String visit(BankAccount item) {
		if (item.getDonationValue() < threshold)
			return "Account type: " + 1 + " Number of associated transactions: " + 1 + " Total amount donated: "
					+ item.getDonationValue();

		return "";
	}

}
