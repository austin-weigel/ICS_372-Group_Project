package buttons;


//import events.ACEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.TemperatureControllerContext;

public class SetOutsideTempButton extends GUIButton implements EventHandler<ActionEvent> {

    public SetOutsideTempButton(String string) {
        super(string);
    }
    
    @Override
    public void handle(ActionEvent event) {
    	//TemperatureControllerContext.instance().handleEvent(ACEvent.instance()); 
    	
    }
}
