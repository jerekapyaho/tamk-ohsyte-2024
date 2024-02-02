import java.util.List;
import java.util.ArrayList;

//
// The "singleton" design pattern.
// Get the only instance by calling getInstance() in your program.
//

public class EventManager {
    private List<Event> events;

    // Private constructor, nobody else can create instances
    private EventManager() {
        this.events = new ArrayList<Event>();
    }

    // Private instance, statically created.
    private static final EventManager INSTANCE = new EventManager();

    // When someone wants a reference, they get it through this method.
    public static EventManager getInstance() {
        return INSTANCE;
    }

    // Any other methods can be public.

    public void addEvent(Event e) {
        this.events.add(e);
    }

    // It may not be a good idea to give a reference to the whole
    // event list. Maybe clone the list instead, and return the clone?
    public List<Event> getEvents() {
        return this.events;
    }
}
