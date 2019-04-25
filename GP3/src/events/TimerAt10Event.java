package events;

/**
 * This class represents a clock tick. The object contains the amount of time
 * left in the timer.
 * 
 * @author Brahma Dathan
 *
 */
public class TimerAt10Event extends TemperatureControllerEvent {
	private static TimerAt10Event instance;

	/**
	 * Private for singleton
	 * 
	 */
	private TimerAt10Event() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static TimerAt10Event instance() {
		if (instance == null) {
			instance = new TimerAt10Event();
		}
		return instance;
	}
}
