package states;

import events.ACEvent;
import events.AllOffEvent;
import events.HeaterEvent;
import events.TimerRanOutEvent;
import timer.Notifiable;
import timer.Timer;

public class FanState extends TemperatureControllerState implements Notifiable {
	private static FanState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private FanState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 *
	 * @return the object
	 */
	public static FanState instance() {
		if (instance == null) {
			instance = new FanState();
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
	 * Process ACEvent request
	 */
	@Override
	public void handleEvent(ACEvent event) {
		TemperatureControllerContext.instance().changeState(ACIdleState.instance());
	}

	/**
	 * Process the timer runs out event
	 */
	@Override
	public void handleEvent(TimerRanOutEvent event) {
		TemperatureControllerContext.instance().changeState(FanIdleState.instance());
	}

	/**
	 * What happens when the system enters this state.
	 */
	@Override
	public void enter() {
		TemperatureControllerContext.instance().showFanOn();
		timer = new Timer(this, 10);
	}

	/**
	 * What happens when the system exits this state.
	 */
	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
