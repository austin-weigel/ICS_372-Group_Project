package buttons;


import events.HeaterEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.TemperatureControllerContext;

public class HeaterButton extends GUIButton implements EventHandler<ActionEvent> {

    public HeaterButton(String string) {
        super(string);
    }
    
    @Override
    public void handle(ActionEvent event) {
    	TemperatureControllerContext.instance().handleEvent(HeaterEvent.instance());
    }
}
