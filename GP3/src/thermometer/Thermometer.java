package thermometer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The gauge allows a certain device event period to be set when created. It
 * sends signals back to it creator.
 *
 * @author Jahia Vang
 *
 */
public class Thermometer implements PropertyChangeListener {
	private int tempValue;
	private Notifiable client;

	/**
	 * Sets up the timer for a certain client with an initial temp value
	 *
	 * @param client
	 *            the client, a Notifiable object
	 * @param tempValue
	 *            the initial time value after which the timer runs out of time.
	 */

	public Thermometer(Notifiable client, int tempValue) {
		this.client = client;
		this.tempValue = tempValue;
		Clock.instance().addPropertyChangeListener(this);
	}

	/**
	 * The temperature value could be changes using this method.
	 *
	 * @param value
	 *            the increment or decrement for the temp value.
	 */
	public void addTempValue(int value) {
		tempValue += value;
	}

	/**
	 * Stops the gauge by deleting itself from the list of observers
	 */
	public void stop() {
		Clock.instance().removePropertyChangeListener(this);
	}

	/**
	 * Returns current temperature value
	 *
	 * @return temperature value
	 */
	public int getTempValue() {
		return tempValue;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// to be implemented
	}
}