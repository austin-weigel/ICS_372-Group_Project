package events;

/**
 * This class represents a the current temp change. The object contains the
 * current temp change left in the thermometer.
 *
 * @author Jahia Vang
 *
 */
public class CurrentTempControllerEvent extends TemperatureControllerEvent {
	private int currentTemp;

	/**
	 * Stores the currentTemp in the Timer.
	 *
	 * @param value
	 *            the amount of time left
	 */
	public CurrentTempControllerEvent(int value) {
		this.currentTemp = value;
	}

	/**
	 * Needed for display purposes
	 */
	public int getTimeLeft() {
		return currentTemp;
	}
}