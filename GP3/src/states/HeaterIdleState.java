package states;

import events.ACEvent;
import events.AllOffEvent;
import events.FanEvent;
import events.IdealTempEvent;
import thermometer.Notifiable;
import thermometer.Thermometer;

public class HeaterIdleState extends TemperatureControllerState implements Notifiable {

	private static HeaterIdleState instance;
	private static Thermometer thermometer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private HeaterIdleState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 *
	 * @return the object
	 */
	public static HeaterIdleState instance() {
		if (instance == null) {
			instance = new HeaterIdleState();
		}
		return instance;
	}

	@Override
	public void handleEvent(AllOffEvent event) {
		TemperatureControllerContext.instance().changeState(AllOffState.instance());
	}

	@Override
	public void handleEvent(ACEvent event) {
		TemperatureControllerContext.instance().changeState(ACIdleState.instance());
	}

	@Override
	public void handleEvent(FanEvent event) {
		TemperatureControllerContext.instance().changeState(FanIdleState.instance());
	}

	public void handleEvent(IdealTempEvent event) {
		TemperatureControllerContext.instance().showCurrentTemp(thermometer.getTempValue());
	}

	@Override
	public void enter() {
		TemperatureControllerContext.instance().showHeaterOn();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
