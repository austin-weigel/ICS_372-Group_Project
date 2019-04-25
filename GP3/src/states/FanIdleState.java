package states;

import events.ACEvent;
import events.AllOffEvent;
import events.HeaterEvent;

public class FanIdleState extends TemperatureControllerState {

	private static FanIdleState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private FanIdleState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static FanIdleState instance() {
		if (instance == null) {
			instance = new FanIdleState();
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
