import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void setEventProvider(EventProvider provider) {
        this.eventProvider = provider;
    }

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

    /**
     * Gets a sorted list of all the categories across all events.
     *
     * @return the category list
     */
    public List<String> getCategories() {
        // Each category string may be added to the set
        // multiple times, but there will be only one of each.
        Set<String> categories = new HashSet<String>();
        for (Event event: this.getEvents()) {
            categories.add(event.getCategory().getValue());
        }

        // Create a new list based on the set of categories,
        // then sort it.
        List<String> result = new ArrayList<String>(categories);
        Collections.sort(result);
        return result;
    }
}
