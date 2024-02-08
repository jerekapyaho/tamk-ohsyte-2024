import java.util.List;

/**
 * Common interface for all event providers 
 * used by `EventManager`.
 */
interface EventProvider {
    List<Event> getEvents();
    boolean addEvent(Event e);
}
