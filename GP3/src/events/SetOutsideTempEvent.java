package events;

public class SetOutsideTempEvent {

	private static SetOutsideTempEvent instance;

	/**
	 * Private for singleton
	 *
	 */
	private SetOutsideTempEvent() {

	}

	/**
	 * For the singleton pattern
	 *
	 * @return the only instance
	 */
	public static SetOutsideTempEvent instance() {
		if (instance == null) {
			instance = new SetOutsideTempEvent();
		}
		return instance;
	}
}