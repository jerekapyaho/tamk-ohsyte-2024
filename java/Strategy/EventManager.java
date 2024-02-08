import java.util.List;

/**
 * Event manager. Implemented as a singleton.
 * Get the only instance by calling `getInstance()` in your program.
 */
public class EventManager {
    // Private constructor, nobody else can create instances
    private EventManager() {
        this.eventProvider = new EmptyEventProvider();
    }

    private EventProvider eventProvider;

    // Private instance, statically created.
    private static final EventManager INSTANCE = new EventManager();

    // When someone wants a reference, they get it through this method.
    public static EventManager getInstance() {
        return INSTANCE;
    }

    public void addEvent(Event e) {
        // pass it on to the event provider
        this.eventProvider.addEvent(e);
    }

    public List<Event> getEvents() {
        return this.eventProvider.getEvents();
    }
}
