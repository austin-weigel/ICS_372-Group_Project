package states;

public class SetTempState {

	private static SetTempState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private SetTempState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 *
	 * @return the object
	 */
	public static SetTempState instance() {
		if (instance == null) {
			instance = new SetTempState();
		}
		return instance;
	}

	public void enter() {
		// TODO Auto-generated method stub

	}

	public void leave() {
		// TODO Auto-generated method stub

	}
}
