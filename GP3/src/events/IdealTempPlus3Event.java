package events;

public class IdealTempPlus3Event extends TemperatureControllerEvent {
	private static IdealTempPlus3Event instance;

	/**
	 * Private for singleton
	 * 
	 */
	private IdealTempPlus3Event() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static IdealTempPlus3Event instance() {
		if (instance == null) {
			instance = new IdealTempPlus3Event();
		}
		return instance;
	}
}
