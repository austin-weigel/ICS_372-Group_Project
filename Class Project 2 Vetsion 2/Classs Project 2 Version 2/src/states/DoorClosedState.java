package states;

import events.CookRequestEvent;
import events.DoorOpenEvent;

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
 * Represents the door closed state
 *
 */
public class DoorClosedState extends MicrowaveState {
    private static DoorClosedState instance;

    /**
     * Private constructor for the singleton pattern
     */
    private DoorClosedState() {
    }

    /**
     * returns the instance
     * 
     * @return this object
     */
    public static DoorClosedState instance() {
        if (instance == null) {
            instance = new DoorClosedState();
        }
        return instance;
    }

    /**
     * handle door open event
     * 
     */

    @Override
    public void handleEvent(DoorOpenEvent event) {
        MicrowaveContext.instance().changeState(DoorOpenState.instance());
    }

    /**
     * handle cook request
     * 
     */

    @Override
    public void handleEvent(CookRequestEvent event) {
        MicrowaveContext.instance().changeState(CookingState.instance());
    }

    /**
     * initialize the state
     * 
     */
    @Override
    public void enter() {
        MicrowaveContext.instance().showLightOff();
    }

    @Override
    public void leave() {
        MicrowaveContext.instance().showLightOn();
    }
}