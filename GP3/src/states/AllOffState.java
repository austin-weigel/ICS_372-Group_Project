package states;

import events.ACEvent;
import events.FanEvent;
import events.HeaterEvent;

public class AllOffState extends TemperatureControllerState {

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
		TemperatureControllerContext.instance().changeState(HeaterIdleState.instance());
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
		// TODO Auto-generated method stub

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
