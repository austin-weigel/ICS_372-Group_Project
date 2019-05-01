package events;

public class SetCurrentTempEvent {

	private static SetCurrentTempEvent instance;

	/**
	 * Private for singleton
	 *
	 */
	private SetCurrentTempEvent() {

	}

	/**
	 * For the singleton pattern
	 *
	 * @return the only instance
	 */
	public static SetCurrentTempEvent instance() {
		if (instance == null) {
			instance = new SetCurrentTempEvent();
		}
		return instance;
	}
}