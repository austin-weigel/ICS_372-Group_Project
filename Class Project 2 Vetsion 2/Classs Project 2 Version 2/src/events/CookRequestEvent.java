package events;

/**
 * Represents the cook request
 *
 */
public class CookRequestEvent extends MicrowaveEvent {
    private static CookRequestEvent instance;

    /**
     * Private for singleton
     * 
     */
    private CookRequestEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static CookRequestEvent instance() {
        if (instance == null) {
            instance = new CookRequestEvent();
        }
        return instance;
    }
}