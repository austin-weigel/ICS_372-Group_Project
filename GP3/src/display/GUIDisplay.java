package display;

import buttons.AcButton;
import buttons.FanButton;
import buttons.HeaterButton;
import buttons.NoDeviceButton;
import buttons.SetCurrentTempButton;
import buttons.SetDesiredTempButton;
import buttons.SetOutsideTempButton;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import states.TemperatureControllerContext;

/**
 * GUI to implement the MicrowaveDisplay interface A pretty elementary interface
 *
 */
public class GUIDisplay extends Application implements TemperatureControllerDisplay {
	
    private GUIButton heater;
    private GUIButton ac;
    private GUIButton fan;
    private GUIButton noDevice;
    private GUIButton setCurrentTemp;
    private GUIButton setOutsideTemp;
    private GUIButton setDesiredTemp;
    
    private Text tempLabel = new Text("Temperature ");
    private Text currentTemp = new Text("            ");
    private Text desiredTemp = new Text("            ");
    private Text outsideTemp = new Text("            ");
    private Text devices = new Text("No Device is on");
    
//	private GUIButton doorCloser;
//	private GUIButton doorOpener;
//	private GUIButton cookButton;
//	private Text doorStatus = new Text("Door Closed");
//	private Text timerValue = new Text("            ");
//	private Text lightStatus = new Text("Light Off");
//	private Text cookingStatus = new Text("Not cooking");
    
	private static TemperatureControllerDisplay display;
	private TemperatureControllerContext temperatureControllerContext;

	public static TemperatureControllerDisplay getInstance() {
		return display;
	}

	/**
	 * Sets up the interface
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		temperatureControllerContext = temperatureControllerContext.instance();
		temperatureControllerContext.setDisplay(this);
		display = this;
		
//		doorCloser = new DoorCloseButton("close door");
//		doorOpener = new DoorOpenButton("open door");
//		cookButton = new CookButton("cook");
		
        heater = new HeaterButton("Heater");
        ac = new AcButton("AC");
        fan = new FanButton("Fan");
        noDevice = new NoDeviceButton("No Device");
        setCurrentTemp = new SetCurrentTempButton("Set Current Room Temp");
        setOutsideTemp = new SetOutsideTempButton("Set Outside Temp");
        setDesiredTemp = new SetDesiredTempButton("Set Desired Room Temp");
        TextField enteredTemp = new TextField();
		

		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10, 10, 10, 10));
		
		pane.add(tempLabel, 0, 0);
        pane.add(enteredTemp, 1, 0);
        pane.add(setCurrentTemp, 2, 0);
        pane.add(setOutsideTemp, 3, 0);
        pane.add(setDesiredTemp, 4, 0);
        pane.add(heater, 0, 1);
        pane.add(ac, 1, 1);
        pane.add(fan, 2, 1);
        pane.add(noDevice, 3, 1);
        pane.add(currentTemp, 0, 2);
        pane.add(desiredTemp, 1, 2);
        pane.add(outsideTemp, 2, 2);
        pane.add(devices, 3, 2);

        showCurrentTemp(0);
        showDesiredTemp(0);
        showOutsideTemp(0);

		
//		pane.add(doorStatus, 0, 0);
//		pane.add(lightStatus, 1, 0);
//		pane.add(timerValue, 2, 0);
//		pane.add(cookingStatus, 3, 0);
//		pane.add(doorCloser, 4, 0);
//		pane.add(doorOpener, 5, 0);
//		pane.add(cookButton, 6, 0);
//		showDoorClosed();
//		showLightOff();
//		showTimeLeft(0);
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Group Project 3");
		try {
			while (temperatureControllerContext == null) {
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
		//lightStatus.setText("Light On");
	}

	/**
	 * Indicate that the light is off
	 */
	@Override
	public void showLightOff() {
		//lightStatus.setText("Light Off");
	}

	/**
	 * Indicate that the door is closed
	 */
	@Override
	public void showDoorClosed() {
		//doorStatus.setText("Door Closed");
	}

	/**
	 * Indicate that the door is opened
	 */
	@Override
	public void showDoorOpened() {
		//doorStatus.setText("Door Opened");
	}

	/**
	 * display the remaining time
	 * 
	 * @param the value remaining
	 */
	@Override
	public void showTimeLeft(int value) {
		//timerValue.setText(" " + value);
	}

	/**
	 * Indicate that it is cooking
	 */
	@Override
	public void showCooking() {
		//cookingStatus.setText("Cooking");
	}

	/**
	 * Indicate that cooking is done
	 */
	@Override
	public void showNotCooking() {
		//cookingStatus.setText("Not cooking");
	}
	
	/**
	 * Indicate the current room temp
	 */
    public void showCurrentTemp(int value) {
    	currentTemp.setText("Current Temp " + value);
    }

	/**
	 * Indicate the desired room temp
	 */
    public void showDesiredTemp(int value) {
    	desiredTemp.setText("Desired Temp " + value);
    }
    
	/**
	 * Indicate the outside temp
	 */
    public void showOutsideTemp(int value) {
    	outsideTemp.setText("Outside Temp " + value);
    }

}