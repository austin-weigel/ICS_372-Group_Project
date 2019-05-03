package states;

import display.TemperatureControllerDisplay;
import events.ACEvent;
import events.AllOffEvent;
import events.FanEvent;
import events.HeaterEvent;
import events.SetCurrentTempEvent;
import events.SetDesireTempEvent;
import events.SetOutsideTempEvent;

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

/**
 * The context is an observer for the clock and stores the context info for
 * states
 *
 */
public class TemperatureControllerContext {
	private TemperatureControllerDisplay display;
	private TemperatureControllerState currentState;
	private static TemperatureControllerContext instance;

	/**
	 * Make it a singleton
	 */
	private TemperatureControllerContext() {
		instance = this;
		currentState = AllOffState.instance();
	}

	/**
	 * Return the instance
	 *
	 * @return the object
	 */
	public static TemperatureControllerContext instance() {
		if (instance == null) {
			instance = new TemperatureControllerContext();
		}
		return instance;
	}

	/**
	 * The display could change. So we have to get its refrence.
	 *
	 * @param display The current display object
	 */
	public void setDisplay(TemperatureControllerDisplay display) {
		this.display = display;
	}

	/**
	 * Lets all off state be the starting state. Adds the object? as an observable
	 * for clock
	 */
	public void initialize() {
		instance.changeState(AllOffState.instance());
	}

	/**
	 * Called from the states to change the current state
	 *
	 * @param nextState the next state
	 */
	public void changeState(TemperatureControllerState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * Process ACEvent request
	 */
	public void handleEvent(ACEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Process AllOffEvent request
	 */
	public void handleEvent(AllOffEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Process FanEvent request
	 */
	public void handleEvent(FanEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Process HeaterEvent request
	 */
	public void handleEvent(HeaterEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 *
	 */
	public void showNoDeviceOn() {
		display.showNoDeviceOn();
	}

	/**
	 * Show that the Fan is on.
	 */
	public void showFanOn() {
		display.showFanOn();
	}

	/**
	 * Show that the AC is on.
	 */
	public void showAcOn() {
		display.showAcOn();
	}

	/**
	 * Show that the Heater is on.
	 */
	public void showHeaterOn() {
		display.showHeaterOn();
	}

	/**
	 * Show the current temperature.
	 */
	public void showCurrentTemp(int currentTemp) {
		display.showCurrentTemp(currentTemp);
	}

	/**
	 * Show the Desired room temp.
	 */
	public void showDesiredTemp(int desiredTemp) {
		display.showDesiredTemp(desiredTemp);
	}

	public int getTemp() {
		return display.getEnteredTemp();
	}

	/**
	 * Show the outside temp.
	 */
	public void showOutsideTemp(int outsideTemp) {
		display.showOutsideTemp(outsideTemp);
	}

	/**
	 * Process SetDesireTempEvent request
	 */
	public void handleEvent(SetDesireTempEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Process SetOutsideTempEvent request
	 */
	public void handleEvent(SetOutsideTempEvent event) {
		currentState.handleEvent(event);

	}

	/**
	 * Process SetCurrentTempEvent request
	 */
	public void handleEvent(SetCurrentTempEvent event) {
		currentState.handleEvent(event);

	}
}