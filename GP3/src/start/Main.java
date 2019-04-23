package start;

import display.GUIDisplay;
import display.TemperatureControllerDisplay;
import javafx.application.Application;
import states.TemperatureControllerContext;
import timer.Clock;

public class Main {
	public static void main(String[] args) {
		Clock.instance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class, null);
			}
		}.start();
		try {
			while (GUIDisplay.getInstance() == null) {
				Thread.sleep(1000);
			}
		} catch (InterruptedException ie) {
		}
		TemperatureControllerDisplay display = GUIDisplay.getInstance();
		TemperatureControllerContext.instance().setDisplay(display);
	}
}
