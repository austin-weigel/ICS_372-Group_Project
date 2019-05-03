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

	/**
	 * Process the timer runs out event
	 */
	@Override
	public void handleEvent(TimerRanOutEvent event) {
		// TemperatureControllerContext.instance().showTimeLeft(0);
		TemperatureControllerContext.instance().changeState(FanState.instance());
	}

	@Override
	public void enter() {
		TemperatureControllerContext.instance().showFanIdle();
		timer = new Timer(this, 10);

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
