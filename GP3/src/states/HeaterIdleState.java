package states;

import events.ACEvent;
import events.AllOffEvent;
import events.FanEvent;
import timer.Notifiable;

public class HeaterIdleState extends TemperatureControllerState implements Notifiable {

	private static HeaterIdleState instance;

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
		TemperatureControllerContext.instance().showHeaterIdle();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
