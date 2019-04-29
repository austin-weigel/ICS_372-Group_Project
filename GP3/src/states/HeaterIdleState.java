package states;

import events.ACEvent;
import events.AllOffEvent;
import events.FanEvent;
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

	@Override
	public void enter() {
		thermometer = new Thermometer(this, 10);
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
