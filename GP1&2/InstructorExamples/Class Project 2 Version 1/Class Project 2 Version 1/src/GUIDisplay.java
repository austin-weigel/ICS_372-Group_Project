
/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * GUI to implement the MicrowaveDisplay interface A pretty elementary interface
 *
 */
public class GUIDisplay extends Application implements MicrowaveDisplay, EventHandler<ActionEvent> {
    private Button doorCloser;
    private Button doorOpener;
    private Button cookButton;
    private Text doorStatus = new Text("Door Closed");
    private Text timerValue = new Text("            ");
    private Text lightStatus = new Text("Light Off");
    private Text cookingStatus = new Text("Not cooking");
    private static MicrowaveDisplay display;
    private Microwave microwave;

    /**
     * Sets up the interface
     */
    public void start(Stage primaryStage) throws Exception {

        display = this;
        doorCloser = new Button("close door");
        doorOpener = new Button("open door");
        cookButton = new Button("cook");

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.add(doorStatus, 0, 0);
        pane.add(lightStatus, 1, 0);
        pane.add(timerValue, 2, 0);
        pane.add(cookingStatus, 3, 0);
        pane.add(doorCloser, 4, 0);
        pane.add(doorOpener, 5, 0);
        pane.add(cookButton, 6, 0);
        showDoorClosed();
        showLightOff();
        showTimeLeft(0);
        doorCloser.setOnAction(this);
        doorOpener.setOnAction(this);
        cookButton.setOnAction(this);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Microwave Version 0");
        microwave = Microwave.instance();
        microwave.setDisplay(this);
        primaryStage.show();
        primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent window) {
                System.exit(0);
            }
        });
    }

    /**
     * Indicate that the light is on
     */
    public void showLightOn() {
        lightStatus.setText("Light On");
    }

    /**
     * Indicate that the light is off
     */
    public void showLightOff() {
        lightStatus.setText("Light Off");
    }

    /**
     * Indicate that the door is closed
     */
    public void showDoorClosed() {
        doorStatus.setText("Door Closed");
    }

    /**
     * Indicate that the door is opened
     */
    public void showDoorOpened() {
        doorStatus.setText("Door Opened");
    }

    /**
     * display the remaining time
     * 
     * @param the
     *            value remaining
     */
    public void showTimeLeft(int value) {
        timerValue.setText(" " + value);
    }

    /**
     * Indicate that it is cooking
     */
    public void showCooking() {
        cookingStatus.setText("Cooking");
    }

    /**
     * Indicate that cooking is done
     */
    public void showNotCooking() {
        cookingStatus.setText("Not cooking");
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource().equals(doorCloser)) {
            microwave.doorClosed();
        } else if (event.getSource().equals(doorOpener)) {
            microwave.doorOpened();
        } else if (event.getSource().equals(cookButton)) {
            microwave.cookRequested();
        }

    }
}