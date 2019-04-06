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
 * Represents a single microwave. Has methods to close and open doors, cook
 * (start or add time), and process clock ticks.
 *
 */
public class Microwave {
    public enum States {
        DOOR_CLOSED_STATE, DOOR_OPENED_STATE, COOKING_STATE
    };

    private int timeLeft = 0;
    private States currentState = States.DOOR_CLOSED_STATE;
    private static Microwave instance;
    private MicrowaveDisplay display;

    /**
     * Sets the state to closed door state, turns light off, and creates the GUI
     * display.
     * 
     */
    private Microwave() {
    }

    /**
     * For the singleton pattern
     * 
     * @return the instance
     */
    public static Microwave instance() {
        if (instance == null) {
            instance = new Microwave();
        }
        return instance;
    }

    public void setDisplay(MicrowaveDisplay display) {
        this.display = display;
        currentState = States.DOOR_CLOSED_STATE;
        timeLeft = 0;
        display.showTimeLeft(timeLeft);
        display.showLightOff();
        display.showDoorClosed();
        display.showNotCooking();
    }

    /**
     * Processes the door close event. Turns the light off and sets time to 0.
     */
    public void doorClosed() {
        if (currentState == States.DOOR_OPENED_STATE) {
            currentState = States.DOOR_CLOSED_STATE;
            display.showDoorClosed();
            display.showNotCooking();
            display.showLightOff();
            timeLeft = 0;
            display.showTimeLeft(0);
        }
    }

    /**
     * Processes the door open event. Turns the light on and cancels cooking.
     */
    public void doorOpened() {
        if (currentState == States.DOOR_CLOSED_STATE || currentState == States.COOKING_STATE) {
            currentState = States.DOOR_OPENED_STATE;
            display.showDoorOpened();
            display.showNotCooking();
            display.showLightOn();
            timeLeft = 0;
            display.showTimeLeft(0);
        }
    }

    /**
     * When the cook request is given, it starts cooking and turns the light on.
     */
    public void cookRequested() {
        if (currentState == States.DOOR_CLOSED_STATE) {
            currentState = States.COOKING_STATE;
            display.showCooking();
            display.showLightOn();
            timeLeft = 10;
            display.showTimeLeft(timeLeft);
        } else if (currentState == States.COOKING_STATE) {
            timeLeft += 10;
            display.showTimeLeft(timeLeft);
        }
    }

    /**
     * For each clock tick, the time to cook is decremented, if applicable. If
     * cooking and timer runs out, the dispaly now is set to not cooking and the
     * light is turned off.
     * 
     */
    public void clockTicked() {
        if (currentState == States.COOKING_STATE) {
            timeLeft--;
            display.showTimeLeft(timeLeft);
            if (timeLeft == 0) {
                currentState = States.DOOR_CLOSED_STATE;
                display.showNotCooking();
                display.showLightOff();
            }
        }
    }

}