package states;

public class ACState extends TemperatureControllerState {
	private static ACState instance;

	private ACState() {
		instance = this;
	}

	public static ACState instance() {
		if (instance == null) {
			instance = new ACState();
		}
		return instance;
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
