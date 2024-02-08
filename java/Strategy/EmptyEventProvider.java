import java.util.List;
import java.util.ArrayList;

/**
 * Empty event provider to use as the default for `EventManager`.
 */
public class EmptyEventProvider implements EventProvider {
    private List<Event> events;

    public EmptyEventProvider() {
        this.events = new ArrayList<Event>();
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public boolean addEvent(Event e) {
        return true;
    }
}
