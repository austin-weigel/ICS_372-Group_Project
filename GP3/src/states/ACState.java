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

	public void handleEvent(AllOffEvent event) {
		TemperatureControllerContext.instance().changeState(AllOffState.instance());
	}

	public void handeEvent(HeaterEvent event) {
		TemperatureControllerContext.instance().changeState(HeaterState.instance());
	}

	public void handleEvent(FanEvent event) {
		TemperatureControllerContext.instance().changeState(FanState.instance());
	}

	@Override
	public void enter() {
		TemperatureControllerContext.instance().showAcOn();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
