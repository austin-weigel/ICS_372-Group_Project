package buttons;


import events.AllOffEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.TemperatureControllerContext;

public class NoDeviceButton extends GUIButton implements EventHandler<ActionEvent> {

    public NoDeviceButton(String string) {
        super(string);
    }
    
    @Override
    public void handle(ActionEvent event) {
    	TemperatureControllerContext.instance().handleEvent(AllOffEvent.instance());
    }
}
