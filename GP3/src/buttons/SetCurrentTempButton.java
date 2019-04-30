package buttons;

import events.SetTempEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.TemperatureControllerContext;

public class SetCurrentTempButton extends GUIButton implements EventHandler<ActionEvent> {

	public SetCurrentTempButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TemperatureControllerContext.instance().handleEvent(SetTempEvent.instance());
	}
}
