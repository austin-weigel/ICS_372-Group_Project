package display;

import buttons.CookButton;
import buttons.DoorCloseButton;
import buttons.DoorOpenButton;
import buttons.GUIButton;

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
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import states.MicrowaveContext;

/**
 * GUI to implement the MicrowaveDisplay interface A pretty elementary interface
 *
 */
public class GUIDisplay extends Application implements MicrowaveDisplay {
    private GUIButton doorCloser;
    private GUIButton doorOpener;
    private GUIButton cookButton;
    private Text doorStatus = new Text("Door Closed");
    private Text timerValue = new Text("            ");
    private Text lightStatus = new Text("Light Off");
    private Text cookingStatus = new Text("Not cooking");
    private static MicrowaveDisplay display;
    private MicrowaveContext microwaveContext;

    public static MicrowaveDisplay getInstance() {
        return display;
    }

    /**
     * Sets up the interface
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        microwaveContext = MicrowaveContext.instance();
        microwaveContext.setDisplay(this);
        display = this;
        doorCloser = new DoorCloseButton("close door");
        doorOpener = new DoorOpenButton("open door");
        cookButton = new CookButton("cook");

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
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Microwave Version 2");
        try {
            while (microwaveContext == null) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {

        }
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
    @Override
    public void showLightOn() {
        lightStatus.setText("Light On");
    }

    /**
     * Indicate that the light is off
     */
    @Override
    public void showLightOff() {
        lightStatus.setText("Light Off");
    }

    /**
     * Indicate that the door is closed
     */
    @Override
    public void showDoorClosed() {
        doorStatus.setText("Door Closed");
    }

    /**
     * Indicate that the door is opened
     */
    @Override
    public void showDoorOpened() {
        doorStatus.setText("Door Opened");
    }

    /**
     * display the remaining time
     * 
     * @param the
     *            value remaining
     */
    @Override
    public void showTimeLeft(int value) {
        timerValue.setText(" " + value);
    }

    /**
     * Indicate that it is cooking
     */
    @Override
    public void showCooking() {
        cookingStatus.setText("Cooking");
    }

    /**
     * Indicate that cooking is done
     */
    @Override
    public void showNotCooking() {
        cookingStatus.setText("Not cooking");
    }

}