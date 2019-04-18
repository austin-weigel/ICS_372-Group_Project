package display;

/**
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 */
public interface MicrowaveDisplay {
    /**
     * Displays the cook time remaining
     * 
     * @param time
     *            remaining time
     */
    public void showTimeLeft(int time);

    /**
     * Indicate that the light is on
     */
    public void showLightOn();

    /**
     * Indicate that the light is off
     */
    public void showLightOff();

    /**
     * Indicate that the door is now closed
     */
    public void showDoorClosed();

    /**
     * Indicate that the door is now open
     */
    public void showDoorOpened();

    /**
     * indicate that cooking has begun
     */
    public void showCooking();

    /**
     * indicate that cooking has ended
     */
    public void showNotCooking();

}