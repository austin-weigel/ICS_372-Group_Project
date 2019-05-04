package states;

import events.ACEvent;
import events.AllOffEvent;
import events.HeaterEvent;
import events.TimerRanOutEvent;
import timer.Notifiable;
import timer.Timer;

public class FanIdleState extends TemperatureControllerState implements Notifiable {

	private static FanIdleState instance;
	private Timer timer;

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

	/**
	 * Process AllOffEvent request.
	 */
	@Override
	public void handleEvent(AllOffEvent event) {
		TemperatureControllerContext.instance().changeState(AllOffState.instance());
	}

	/**
	 * Process ACEvent request.
	 */
	@Override
	public void handleEvent(ACEvent event) {
		TemperatureControllerContext.instance().changeState(ACIdleState.instance());
	}

	/**
	 * Process HeaterEvent request.
	 */
	@Override
	public void handleEvent(HeaterEvent event) {
		TemperatureControllerContext.instance().changeState(HeaterIdleState.instance());
	}

	/**
	 * Process the TimerRanOutEvent.
	 */
	@Override
	public void handleEvent(TimerRanOutEvent event) {
		TemperatureControllerContext.instance().changeState(FanState.instance());
	}

	/**
	 * What happens when the system enters this state.
	 */
	@Override
	public void enter() {
		TemperatureControllerContext.instance().showFanIdle();
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
