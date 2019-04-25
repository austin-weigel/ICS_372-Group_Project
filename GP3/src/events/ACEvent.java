package events;

public class ACEvent extends TemperatureControllerEvent {
	private static ACEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private ACEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static ACEvent instance() {
		if (instance == null) {
			instance = new ACEvent();
		}
		return instance;
	}
}
