package events;

public class SetDesireTempEvent {

	private static SetDesireTempEvent instance;

	/**
	 * Private for singleton
	 *
	 */
	private SetDesireTempEvent() {

	}

	/**
	 * For the singleton pattern
	 *
	 * @return the only instance
	 */
	public static SetDesireTempEvent instance() {
		if (instance == null) {
			instance = new SetDesireTempEvent();
		}
		return instance;
	}
}