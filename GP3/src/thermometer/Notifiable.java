package thermometer;

import events.ACEvent;
import events.AllOffEvent;
import events.FanEvent;
import events.HeaterEvent;
import events.IdealTempEvent;
import events.IdealTempPlus3Event;
import events.IdealTempSub3Event;
import events.TimerAt10Event;
import events.TimerTickedEvent;

/**
 * An entity that can be
 * 
 * @author Jahia Vang
 *
 */
public interface Notifiable {

	public void handleEvent(IdealTempEvent event);

	public void handleEvent(IdealTempPlus3Event event);

	public void handleEvent(IdealTempSub3Event event);

	public void handleEvent(TimerAt10Event event);

	public void handleEvent(TimerTickedEvent event);

	public void handleEvent(FanEvent event);

	public void handleEvent(AllOffEvent event);

	public void handleEvent(HeaterEvent event);

	public void handleEvent(ACEvent event);
}
