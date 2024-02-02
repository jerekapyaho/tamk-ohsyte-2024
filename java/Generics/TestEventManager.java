import java.time.LocalDate;
import java.util.List;

public class TestEventManager {
    public static void main(String[] args) {
        // Get a reference to the only instance 
        // of the event manager class.
        EventManager em = EventManager.getInstance();

        Event e1 = new Event(
            LocalDate.now(),
            new Description("Studied the singleton pattern"), 
            new Category("java")
        );
        em.addEvent(e1);

        List<Event> events = em.getEvents();
        for (Event e : events) {
            System.out.println(e);
        }
    }
}
