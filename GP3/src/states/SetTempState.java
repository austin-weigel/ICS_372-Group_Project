package states;

import events.SetCurrentTempEvent;

public class SetTempState extends TemperatureControllerState {

	private static SetTempState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private SetTempState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 *
	 * @return the object
	 */
	public static SetTempState instance() {
		if (instance == null) {
			instance = new SetTempState();
		}
		return instance;
	}

	public void handleEvent(SetCurrentTempEvent event) {
		TemperatureControllerContext.instance().showCurrentTemp(100);
		// not working

	}

	public void enter() {
		TemperatureControllerContext.instance().showCurrentTemp(0);
	}

	public void leave() {
		// TODO Auto-generated method stub

	}
}
