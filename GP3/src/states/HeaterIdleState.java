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

	/**
	 * Process the AllOffEvent.
	 */
	@Override
	public void handleEvent(AllOffEvent event) {
		TemperatureControllerContext.instance().changeState(AllOffState.instance());
	}

	/**
	 * Process the ACEvent.
	 */
	@Override
	public void handleEvent(ACEvent event) {
		TemperatureControllerContext.instance().changeState(ACIdleState.instance());
	}

	/**
	 * Process the FanEvent.
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
		TemperatureControllerContext.instance().showHeaterIdle();
	}

	/**
	 * What happens when the system exits this state.
	 */
	@Override
	public void leave() {
	}

}
