
public class BankAccount implements Visitable {

	public int getDonationValue() {
		return 0;
	}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
