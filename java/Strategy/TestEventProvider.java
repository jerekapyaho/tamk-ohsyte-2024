import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

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
        events.add(
            new Event(
                LocalDate.parse("2020-11-12"),
                new Description("macOS 11 Big Sur released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2015-09-30"),
                new Description("OS X 10.11 El Capitan released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2019-10-07"),
                new Description("macOS 10.15 Catalina released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2017-09-25"),
                new Description("macOS 10.13 High Sierra released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2007-10-26"),
                new Description("Mac OS X 10.5 Leopard released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2011-07-20"),
                new Description("Mac OS X 10.7 Lion released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2013-10-22"),
                new Description("OS X 10.9 Mavericks released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2018-09-24"),
                new Description("macOS 10.14 Mojave released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2021-10-25"),
                new Description("macOS 12 Monterey released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2012-07-25"),
                new Description("OS X 10.8 Mountain Lion released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2016-09-20"),
                new Description("macOS 10.12 Sierra released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2009-08-28"),
                new Description("Mac OS X 10.6 Snow Leopard released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2023-09-26"),
                new Description("macOS 14 Sonoma released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2005-04-29"),
                new Description("Mac OS X 10.4 Tiger released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2022-10-24"),
                new Description("macOS 13 Ventura released"),
                new Category("apple")
            )
        );

        events.add(
            new Event(
                LocalDate.parse("2014-10-16"),
                new Description("OS X 10.10 Yosemite released"),
                new Category("apple")
            )
        );
    }
}
