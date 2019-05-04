package states;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import timer.Clock;

public class TemperatureManager implements PropertyChangeListener {
	private static TemperatureManager instance;
	private int currentTemp = 70;
	private int desiredTemp = 70;
	private int outsideTemp = 80;

	@Override
	/**
	 * This method is responsible for handling the change of temperature and
	 * managing temperature variance.
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

		/**
		 * Handle the case where the Heater is currently running. If the temperature is
		 * still not the desired temp, continue running. Otherwise, revert back to the
		 * idle state.
		 */
		if (currentState instanceof HeaterState) {
			if (currentTemp < desiredTemp - 1) {
				currentTemp += 2;
			} else {
				TemperatureControllerContext.instance().changeState(HeaterIdleState.instance());
			}
		}

		/**
		 * Handle the case where the AC is currently running. If the temperature is
		 * still not the desired temp, continue running. Otherwise, revert back to the
		 * idle state.
		 */
		if (currentState instanceof ACState) {
			if (currentTemp > desiredTemp + 1) {
				currentTemp -= 2;
			} else {
				TemperatureControllerContext.instance().changeState(ACIdleState.instance());
			}
		}

		/**
		 * Handle the case where the Heater is currently idle. If the current
		 * temperature is three degrees or more away from the desired temperature, run
		 * the Heater.
		 */
		if (currentState instanceof HeaterIdleState && currentTemp <= desiredTemp - 3) {
			TemperatureControllerContext.instance().changeState(HeaterState.instance());
		}

		/**
		 * Handle the case where the AC is currently idle. If the current temperature is
		 * three degrees or more away from the desired temperature, run the AC.
		 */
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
