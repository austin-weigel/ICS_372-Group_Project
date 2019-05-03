package timer;

import events.TimerRanOutEvent;
import events.TimerTickedEvent;

/**
 * An entity that can be notified of timing events
 *
 * @author Brahma Dathan
 *
 */
public interface Notifiable {
	/**
	 * Process timer ran out
	 * 
	 * @param event The TimerRanOutEvent
	 */
	public void handleEvent(TimerRanOutEvent event);

	/**
	 * Process timer ticks
	 * 
	 * @param event The TimerTickedEvent
	 */
	public void handleEvent(TimerTickedEvent event);
}
