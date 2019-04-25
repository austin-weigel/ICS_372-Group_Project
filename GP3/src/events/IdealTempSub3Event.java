package events;

public class IdealTempSub3Event extends TemperatureControllerEvent {
	private static IdealTempSub3Event instance;

	/**
	 * Private for singleton
	 * 
	 */
	private IdealTempSub3Event() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static IdealTempSub3Event instance() {
		if (instance == null) {
			instance = new IdealTempSub3Event();
		}
		return instance;
	}
}
