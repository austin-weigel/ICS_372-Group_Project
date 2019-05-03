package states;

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
	 * Process the timer runs out event
	 */
	@Override
	public void handleEvent(TimerRanOutEvent event) {
		TemperatureControllerContext.instance().changeState(FanIdleState.instance());
	}

	@Override
	public void enter() {
		TemperatureControllerContext.instance().showFanOn();
		timer = new Timer(this, 2);
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
