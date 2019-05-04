package buttons;

import events.SetOutsideTempEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.TemperatureControllerContext;

/**
 * 
 * @author Joseph Schreifels, Jahia Vang, Austin Weigel, Ryan Brodsky
 *
 *         Pass the button clicked event along to the
 *         TemperatureControllerContext.
 */
public class SetOutsideTempButton extends GUIButton implements EventHandler<ActionEvent> {

	public SetOutsideTempButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TemperatureControllerContext.instance().handleEvent(SetOutsideTempEvent.instance());

	}
}
