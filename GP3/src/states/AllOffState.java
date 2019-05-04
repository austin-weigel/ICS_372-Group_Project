package states;

import events.ACEvent;
import events.FanEvent;
import events.HeaterEvent;
import timer.Notifiable;

public class AllOffState extends TemperatureControllerState implements Notifiable {
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

	/**
	 * Process HeaterEvent request
	 */
	@Override
	public void handleEvent(HeaterEvent event) {
		TemperatureControllerContext.instance().changeState(HeaterIdleState.instance());
	}

	/**
	 * Process ACEvent request
	 */
	@Override
	public void handleEvent(ACEvent event) {
		TemperatureControllerContext.instance().changeState(ACIdleState.instance());
	}

	/**
	 * Process FanEvent request
	 */
	@Override
	public void handleEvent(FanEvent event) {
		TemperatureControllerContext.instance().changeState(FanIdleState.instance());
	}

	/**
	 * What happens when the system enters this state.
	 */
	@Override
	public void enter() {
		TemperatureControllerContext.instance().showNoDeviceOn();
	}

	/**
	 * What happens when the system exits this state.
	 */
	@Override
	public void leave() {
	}
}
