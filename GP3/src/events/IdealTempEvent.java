package events;

public class IdealTempEvent extends TemperatureControllerEvent {
	private static IdealTempEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private IdealTempEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static IdealTempEvent instance() {
		if (instance == null) {
			instance = new IdealTempEvent();
		}
		return instance;
	}
}
