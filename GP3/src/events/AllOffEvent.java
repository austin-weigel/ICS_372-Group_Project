package events;

public class AllOffEvent extends TemperatureControllerEvent {
	private static AllOffEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private AllOffEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static AllOffEvent instance() {
		if (instance == null) {
			instance = new AllOffEvent();
		}
		return instance;
	}
}
