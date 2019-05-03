package thermometer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import states.ACIdleState;
import states.ACState;
import states.HeaterIdleState;
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
	/**
	 * This method is responsible for handling the change of temperatures.
	 */
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

		// Is the heater running?
		if (currentState instanceof HeaterState) {
			if (currentTemp < desiredTemp - 1) {
				currentTemp += 2;
			} else {
				TemperatureControllerContext.instance().changeState(HeaterIdleState.instance());
			}
		}
		// Is the AC running?
		if (currentState instanceof ACState) {
			if (currentTemp > desiredTemp + 1) {
				currentTemp -= 2;
			} else {
				TemperatureControllerContext.instance().changeState(ACIdleState.instance());
			}
		}

		// Is the heater on?
		if (currentState instanceof HeaterIdleState && currentTemp <= desiredTemp - 3) {
			TemperatureControllerContext.instance().changeState(HeaterState.instance());
		}

		// Is the AC on?
		if (currentState instanceof ACIdleState && currentTemp >= desiredTemp + 3) {
			TemperatureControllerContext.instance().changeState(ACState.instance());
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
