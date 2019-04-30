package events;

public class SetTempEvent extends TemperatureControllerEvent {
	private static SetTempEvent instance;

	private SetTempEvent() {

	}

	public static SetTempEvent instance() {
		if (instance == null) {
			instance = new SetTempEvent();
		}
		return instance;
	}
}