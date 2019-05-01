package states;

import events.ACEvent;
import events.AllOffEvent;
import events.FanEvent;
import events.HeaterEvent;
import events.IdealTempEvent;
import events.IdealTempPlus3Event;
import events.IdealTempSub3Event;
import events.SetCurrentTempEvent;
import events.SetDesireTempEvent;
import events.SetOutsideTempEvent;
import events.TimerAt10Event;
import events.TimerTickedEvent;

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
 * Super class for all states
 *
 *
 */
public abstract class TemperatureControllerState {

	/**
	 * Initializes the state
	 */
	public abstract void enter();

	/**
	 * Performs any necessary clean up while leaving the state
	 */
	public abstract void leave();

	/**
	 * Specifies the actions to be taken when the Cook button is pressed.
	 */
	public void handleEvent(ACEvent event) {

	}

	/**
	 * Process door open request
	 */
	public void handleEvent(AllOffEvent event) {

	}

	/**
	 * Process door close request
	 */
	public void handleEvent(FanEvent event) {

	}

	/**
	 * Process clock tick Generates the timer runs out event
	 */
	public void handleEvent(HeaterEvent event) {

	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	public void handleEvent(IdealTempEvent event) {

	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	public void handleEvent(IdealTempPlus3Event event) {

	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	public void handleEvent(IdealTempSub3Event event) {

	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	public void handleEvent(TimerAt10Event event) {

	}

	public void handleEvent(TimerTickedEvent event) {

	}

	public void handleEvent(SetDesireTempEvent event) {

	}

	public void handleEvent(SetOutsideTempEvent event) {
		// TODO Auto-generated method stub

	}

	public void handleEvent(SetCurrentTempEvent event) {
		// TODO Auto-generated method stub

	}

}