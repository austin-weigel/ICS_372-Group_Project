package states;

import events.ACEvent;
import events.FanEvent;
import events.HeaterEvent;
import events.TimerTickedEvent;
import timer.Timer;

public class AllOffState extends TemperatureControllerState {

	private static AllOffState instance;
	private Timer timer;

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

	/**
	 * Process clock tick event
	 */
	@Override
	public void handleEvent(TimerTickedEvent event) {
		// Needs to be implemented
		System.out.println("");
	}

	/**
	 * Process the timer runs out event
	 */

	@Override
	public void enter() {
		// timer = new Timer(this,10);
		TemperatureControllerContext.instance().showNoDeviceOn();

	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
