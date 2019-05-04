package states;

import events.AllOffEvent;
import events.FanEvent;
import events.HeaterEvent;

/**
 * If the machine is in this state, the AC is running.
 * 
 * @author Joseph Schreifels
 *
 */
public class ACState extends TemperatureControllerState {
	private static ACState instance;

	/**
	 * Private for the singleton pattern
	 */
	private ACState() {
		instance = this;
	}

	/**
	 * For singleton
	 *
	 * @return the object
	 */
	public static ACState instance() {
		if (instance == null) {
			instance = new ACState();
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
	 * Process HeaterEvent request
	 */
	@Override
	public void handleEvent(HeaterEvent event) {
		TemperatureControllerContext.instance().changeState(HeaterIdleState.instance());
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
		TemperatureControllerContext.instance().showAcOn();
	}

	/**
	 * What happens when the system exits this state.
	 */
	@Override
	public void leave() {
	}
}
