package events;

public class IdealTempSub3Event extends TemperatureControllerEvent {
	private int currentTemp;

	private IdealTempSub3Event(int value) {
		this.currentTemp = value;
	}

	public int getTimeLeft() {
		return currentTemp;
	}

}
