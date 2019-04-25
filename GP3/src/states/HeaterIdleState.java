package states;

import events.ACEvent;
import events.AllOffEvent;
import events.FanEvent;
import timer.Notifiable;
import timer.TimerRanOutEvent;
import timer.TimerTickedEvent;

public class HeaterIdleState extends TemperatureControllerState implements Notifiable {

	private static HeaterIdleState instance;
	private static Timer timer;

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

	@Override
	public void handleEvent(AllOffEvent event) {
		TemperatureControllerContext.instance().changeState(AllOffState.instance());
	}

	@Override
	public void handleEvent(ACEvent event) {
		TemperatureControllerContext.instance().changeState(ACIdleState.instance());
	}

	@Override
	public void handleEvent(FanEvent event) {
		TemperatureControllerContext.instance().changeState(FanIdleState.instance());
	}

	@Override
	public void enter() {
		timer = new Timer(10);
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		if (TemperatureControllerContext.getInsideTemp() != TemperatureControllerContext.getOutsideTemp) {

		}
	}

	@Override
	public void handleEvent(TimerRanOutEvent event) {
		// TODO Auto-generated method stub

	}

}
