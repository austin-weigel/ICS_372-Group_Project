package states;

import events.HeaterEvent;
import events.IdealTempEvent;
import events.IdealTempSub3Event;
import thermometer.Thermometer;

public class HeaterState extends TemperatureControllerState {
	private static HeaterState instance;
	private Thermometer thermometer;

	/**
	 * Private for the singleton pattern
	 */
	private HeaterState() {
	}

	/**
	 * For singleton
	 *
	 * @return the object
	 */
	public static HeaterState instance() {
		if (instance == null) {
			instance = new HeaterState();
		}
		return instance;
	}

	/**
	 * Process heater on request
	 */
	@Override
	public void handleEvent(HeaterEvent event) {
		thermometer.addTempValue(10); // needs fixing
		TemperatureControllerContext.instance().showCurrentTemp(thermometer.getTempValue());
	}

	public void handleEvent(IdealTempEvent event) {
		// to be implemented
	}

	public void handleEvent(IdealTempSub3Event event) {
		// to be implemented
	}

	@Override
	public void enter() {
		TemperatureControllerContext.instance().showHeaterOn();
		TemperatureControllerContext.instance().showCurrentTemp(thermometer.getTempValue());
	}

	/**
	 * Performs any necessary clean up while leaving the state
	 */
	public void leave() {
		thermometer.stop();
		thermometer = null;
		// not sure
	}

}
