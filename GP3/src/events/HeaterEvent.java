package events;

public class HeaterEvent extends TemperatureControllerEvent {
	private static HeaterEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private HeaterEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static HeaterEvent instance() {
		if (instance == null) {
			instance = new HeaterEvent();
		}
		return instance;
	}
}
