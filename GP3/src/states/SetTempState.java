package states;

import events.SetCurrentTempEvent;
import events.SetDesireTempEvent;
import events.SetOutsideTempEvent;
import thermometer.Notifiable;
import thermometer.Thermometer;

public class SetTempState extends TemperatureControllerState implements Notifiable {
	private Thermometer thermometer;
	private int currentTemp = 9;
	private int desireTemp = 9;
	private int outsideTemp = 9;
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
		this.currentTemp = TemperatureControllerContext.instance().getTemp();
		thermometer = new Thermometer(this, currentTemp);
		TemperatureControllerContext.instance().showCurrentTemp(thermometer.getTempValue());

	}

	public void handleEvent(SetOutsideTempEvent event) {
		this.outsideTemp = TemperatureControllerContext.instance().getTemp();
		TemperatureControllerContext.instance().showOutsideTemp(outsideTemp);
	}

	public void handleEvent(SetDesireTempEvent event) {
		this.desireTemp = TemperatureControllerContext.instance().getTemp();
		TemperatureControllerContext.instance().showDesiredTemp(desireTemp);

	}

	public int getOutsideTemp() {
		return outsideTemp;
	}

	public int getDesireTemp() {
		return desireTemp;
	}

	public void enter() {
		TemperatureControllerContext.instance().showCurrentTemp(thermometer.getTempValue());
		TemperatureControllerContext.instance().showOutsideTemp(outsideTemp);
		TemperatureControllerContext.instance().showDesiredTemp(desireTemp);
	}

	public void leave() {
		TemperatureControllerContext.instance().showCurrentTemp(thermometer.getTempValue());
		TemperatureControllerContext.instance().showOutsideTemp(outsideTemp);
		TemperatureControllerContext.instance().showDesiredTemp(desireTemp);

	}
}
