package events;

/**
 * Represents the cook request
 *
 */
public class FanEvent extends TemperatureControllerEvent {
	private static FanEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private FanEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static FanEvent instance() {
		if (instance == null) {
			instance = new FanEvent();
		}
		return instance;
	}
}