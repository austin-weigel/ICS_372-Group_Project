package states;

import events.ACEvent;
import events.AllOffEvent;
import events.FanEvent;

public class HeaterState extends TemperatureControllerState {
	private static HeaterState instance;

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
	 * Process AllOffEvent request
	 */
	@Override
	public void handleEvent(AllOffEvent event) {
		TemperatureControllerContext.instance().changeState(AllOffState.instance());
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
		TemperatureControllerContext.instance().showHeaterOn();
	}

	/**
	 * Performs any necessary clean up while leaving the state
	 */
	public void leave() {
	}
}
