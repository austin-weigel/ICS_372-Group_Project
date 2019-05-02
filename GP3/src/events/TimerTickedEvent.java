package events;

/**
 * This class represents a clock tick. The object contains the amount of time
 * left in the timer.
 * 
 * @author Brahma Dathan
 *
 */
public class TimerTickedEvent extends TemperatureControllerEvent {
	private int timeLeft;

	/**
	 * Not a singleton Stores the amount of time left in the Timer. This is
	 * needed for the fan idle state to sit for 10 minutes
	 * 
	 * @param value
	 *            the amount of time left
	 */
	public TimerTickedEvent(int value) {
		this.timeLeft = value;
	}

	/**
	 * Needed for display purposes
	 */
	public int getTimeLeft() {
		return timeLeft;
	}
}
