package buttons;

import events.CookRequestEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.MicrowaveContext;

/**
 * The button for cook request
 * 
 * @author Brahma Dathan
 *
 */
public class CookButton extends GUIButton implements EventHandler<ActionEvent> {
    /**
     * The button for cooking
     * 
     * @param string
     */
    public CookButton(String string) {
        super(string);
    }

    @Override
    public void handle(ActionEvent event) {
        MicrowaveContext.instance().handleEvent(CookRequestEvent.instance());
    }
}