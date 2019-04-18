package events;

/**
 * Represents the TimerRanOut event.
 *
 */
public class TimerRanOutEvent extends MicrowaveEvent {
    private static TimerRanOutEvent instance;

    /**
     * Private for singleton
     * 
     */
    private TimerRanOutEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static TimerRanOutEvent instance() {
        if (instance == null) {
            instance = new TimerRanOutEvent();
        }
        return instance;
    }
}