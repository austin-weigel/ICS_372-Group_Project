package thermometer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import states.ACState;
import states.HeaterState;
import states.TemperatureControllerContext;
import states.TemperatureControllerState;
import timer.Clock;

public class TemperatureManager implements PropertyChangeListener {
	private static TemperatureManager instance;
	private int currentTemp;
	private int desiredTemp;
	private int outsideTemp;

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

		// Natural increase/decrease of the current temperature based on the outside
		// temperature.
		if (currentTemp < outsideTemp) {
			currentTemp++;
		}
		if (currentTemp > outsideTemp) {
			currentTemp--;
		}

		TemperatureControllerState currentState = TemperatureControllerContext.instance().getCurrentState();

		// Is the heater on?
		if (currentState instanceof HeaterState) {
			currentTemp += 2;
		}
		// Is the AC on?
		if (currentState instanceof ACState) {
			currentTemp -= 2;
		}

		// Show the user the changes.
		TemperatureControllerContext.instance().showCurrentTemp(currentTemp);
	}

	/**
	 * Make it a singleton
	 */
	private TemperatureManager() {
		instance = this;
		Clock.instance().addPropertyChangeListener(this);
	}

	/**
	 * Return the instance
	 *
	 * @return the object
	 */
	public static TemperatureManager instance() {
		if (instance == null) {
			instance = new TemperatureManager();
		}
		return instance;
	}

	public int getCurrentTemp() {
		return currentTemp;
	}

	public void setCurrentTemp(int currentTemp) {
		this.currentTemp = currentTemp;
	}

	public int getDesireTemp() {
		return desiredTemp;
	}

	public void setDesiredTemp(int desireTemp) {
		this.desiredTemp = desireTemp;
	}

	public int getOutsideTemp() {
		return outsideTemp;
	}

	public void setOutsideTemp(int outsideTemp) {
		this.outsideTemp = outsideTemp;
	}
}
