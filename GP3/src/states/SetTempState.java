package states;

import events.SetCurrentTempEvent;
import events.SetDesireTempEvent;
import events.SetOutsideTempEvent;
import thermometer.Notifiable;
import thermometer.Thermometer;

public class SetTempState extends TemperatureControllerState implements Notifiable {
	private Thermometer thermometer;

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
		int temp = TemperatureControllerContext.instance().getTemp();
		thermometer = new Thermometer(this, temp);
		TemperatureControllerContext.instance().showCurrentTemp(thermometer.getTempValue());

	}

	public void handleEvent(SetOutsideTempEvent event) {
		int temp = TemperatureControllerContext.instance().getTemp();
		TemperatureControllerContext.instance().showOutsideTemp(temp);
	}

	public void handleEvent(SetDesireTempEvent event) {
		int temp = TemperatureControllerContext.instance().getTemp();
		TemperatureControllerContext.instance().showDesiredTemp(temp);

	}

	public void enter() {
		// test
		TemperatureControllerContext.instance().showCurrentTemp(thermometer.getTempValue());

	}

	public void leave() {
		// TODO Auto-generated method stub

	}
}
