package buttons;

import events.SetDesireTempEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.TemperatureControllerContext;

public class SetDesiredTempButton extends GUIButton implements EventHandler<ActionEvent> {

	public SetDesiredTempButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TemperatureControllerContext.instance().handleEvent(SetDesireTempEvent.instance());

	}
}
