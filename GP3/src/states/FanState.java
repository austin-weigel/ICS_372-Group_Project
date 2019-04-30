package states;

public class FanState extends TemperatureControllerState {
	private static FanState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private FanState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 *
	 * @return the object
	 */
	public static FanState instance() {
		if (instance == null) {
			instance = new FanState();
		}
		return instance;
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
