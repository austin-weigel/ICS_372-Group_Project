package states;

import events.AllOffEvent;
import events.FanEvent;
import events.HeaterEvent;

public class ACIdleState extends TemperatureControllerState {

	private static ACIdleState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private ACIdleState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static ACIdleState instance() {
		if (instance == null) {
			instance = new ACIdleState();
		}
		return instance;
	}

	@Override
	public void handleEvent(AllOffEvent event) {
		TemperatureControllerContext.instance().changeState(AllOffState.instance());
	}

	@Override
	public void handleEvent(FanEvent event) {
		TemperatureControllerContext.instance().changeState(FanIdleState.instance());
	}

	@Override
	public void handleEvent(HeaterEvent event) {
		TemperatureControllerContext.instance().changeState(HeaterIdleState.instance());
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
