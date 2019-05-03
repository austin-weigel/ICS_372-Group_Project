package states;

import events.ACEvent;
import events.FanEvent;
import events.HeaterEvent;
import events.IdealTempEvent;
import thermometer.Notifiable;
import thermometer.Thermometer;

public class AllOffState extends TemperatureControllerState implements Notifiable {
	private Thermometer thermometer;
	private static AllOffState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private AllOffState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 *
	 * @return the object
	 */
	public static AllOffState instance() {
		if (instance == null) {
			instance = new AllOffState();
		}
		return instance;
	}

	@Override
	public void handleEvent(HeaterEvent event) {
		TemperatureControllerContext.instance().changeState(HeaterState.instance());
	}

	@Override
	public void handleEvent(ACEvent event) {
		TemperatureControllerContext.instance().changeState(ACState.instance());
	}

	@Override
	public void handleEvent(FanEvent event) {
		TemperatureControllerContext.instance().changeState(FanIdleState.instance());
	}

	/**
	 * Process current temp to move to outside temp by 1 degree per min
	 */
	@Override
	public void handleEvent(IdealTempEvent event) {
		TemperatureControllerContext.instance().showCurrentTemp(thermometer.getTempValue());
	}

	/**
	 * Process the timer runs out event
	 */

	@Override
	public void enter() {
		TemperatureControllerContext.instance().showNoDeviceOn();

	}

	@Override
	public void leave() {
		// not sure what happens when we leave this state
	}

}
