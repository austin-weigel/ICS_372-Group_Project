package events;

public class IdealTempEvent extends TemperatureControllerEvent {
	private int currentTemp;

	private IdealTempEvent(int value) {
		this.currentTemp = value;
	}

	public int getTimeLeft() {
		return currentTemp;
	}
}
