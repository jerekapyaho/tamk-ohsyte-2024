import java.util.List;
import java.util.ArrayList;

public class TestEventProvider implements EventProvider {
    private List<Event> events;
    
    public TestEventProvider() {
        this.events = new ArrayList<Event>();
        this.addTestEvents();
    }

    //
    // EventProvider implementation
    //

    public List<Event> getEvents() {
        return this.events;
    }

    public boolean addEvent(Event e) {
        return true;
    }

    private void addTestEvents() {

    }
}
