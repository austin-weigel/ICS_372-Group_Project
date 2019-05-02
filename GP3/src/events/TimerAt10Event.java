package events;

/**
 * This class represents a clock tick. The object contains the amount of time
 * left in the timer.
 * 
 * @author Brahma Dathan
 *
 */
public class TimerAt10Event extends TemperatureControllerEvent {
	/**
	 * Not a singleton This event is for fan not idle state. The timer to tick
	 * for air being blown at 10 minutes
	 */
	private int timeLeft;

	private TimerAt10Event(int value) {
		this.timeLeft = value;
	}

	public int getTimeLeft() {
		return timeLeft;
	}
}
