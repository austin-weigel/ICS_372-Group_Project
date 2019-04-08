public interface Visitable {
	/**
	 * Credit cards and bank accounts will be forced to implement this method,
	 * through which they will connect to the appropriate method in the
	 * PaymentVisitor class
	 */
	public String accept(Visitor vistor);
}
