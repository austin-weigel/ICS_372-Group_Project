
public class PaymentVisitor implements Visitor {

	int threshold = 1;

	public PaymentVisitor() {
	}

	@Override
	public String visit(CreditCard item) {
		if (item.getAmount() < threshold)
			return "Account type: " + 1 + " Number of associated transactions: " + 1 + " Total amount donated: "
					+ item.getAmount();

		return "";
	}

	@Override
	public String visit(BankAccount item) {
		if (item.getAmount() < threshold)
			return "Account type: " + 1 + " Number of associated transactions: " + 1 + " Total amount donated: "
					+ item.getAmount();

		return "";
	}

}
