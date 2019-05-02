package display;

import buttons.AcButton;
import buttons.FanButton;
import buttons.GUIButton;
import buttons.HeaterButton;
import buttons.NoDeviceButton;
import buttons.SetCurrentTempButton;
import buttons.SetDesiredTempButton;
import buttons.SetOutsideTempButton;

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

	private TextField enteredTemp = new TextField();

	private Text tempLabel = new Text("Temperature ");
	private Text currentTemp = new Text("            ");
	private Text desiredTemp = new Text("            ");
	private Text outsideTemp = new Text("            ");
	private Text deviceStatus = new Text("             ");

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
		temperatureControllerContext = TemperatureControllerContext.instance();
		temperatureControllerContext.setDisplay(this);
		display = this;

		heater = new HeaterButton("Heater");
		ac = new AcButton("AC");
		fan = new FanButton("Fan");
		noDevice = new NoDeviceButton("No Device");
		setCurrentTemp = new SetCurrentTempButton("Set Current Room Temp");
		setOutsideTemp = new SetOutsideTempButton("Set Outside Temp");
		setDesiredTemp = new SetDesiredTempButton("Set Desired Room Temp");

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
		pane.add(deviceStatus, 3, 2);

		showCurrentTemp(0);
		showDesiredTemp(0);
		showOutsideTemp(0);
		showNoDeviceOn();

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
	 * Indicate that no device is on
	 */
	@Override
	public void showNoDeviceOn() {
		deviceStatus.setText("No device is on");
	}

	/**
	 * Indicate that Fan is on
	 */
	@Override
	public void showFanOn() {
		deviceStatus.setText("Fan is on");
	}

	/**
	 * Indicate that AC is on
	 */
	@Override
	public void showAcOn() {
		deviceStatus.setText("AC is on");
	}

	/**
	 * Indicate that heater is on
	 */
	@Override
	public void showHeaterOn() {
		deviceStatus.setText("Heater is on");
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

	public int getEnteredTemp() {
		return Integer.parseInt(enteredTemp.getText());
	}

}