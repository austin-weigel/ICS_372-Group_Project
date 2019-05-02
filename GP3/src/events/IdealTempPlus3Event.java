package events;

public class IdealTempPlus3Event extends TemperatureControllerEvent {
	private int currentTemp;

	private IdealTempPlus3Event(int value) {
		this.currentTemp = value;
	}

	public int getTimeLeft() {
		return currentTemp;
	}
}
