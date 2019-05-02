package states;

import events.ACEvent;
import events.AllOffEvent;
import events.FanEvent;
import events.HeaterEvent;
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
		TemperatureControllerContext.instance().showCurrentTemp(thermometer.getTempValue());
	}

	public void handleEvent(IdealTempSub3Event event) {
		TemperatureControllerContext.instance().showCurrentTemp(thermometer.getTempValue());
	}

	public void handleEvent(AllOffEvent event) {
		TemperatureControllerContext.instance().changeState(AllOffState.instance());
	}

	public void handeEvent(ACEvent event) {
		TemperatureControllerContext.instance().changeState(ACState.instance());
	}

	public void handleEvent(FanEvent event) {
		TemperatureControllerContext.instance().changeState(FanState.instance());
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

		// not sure
	}

}
