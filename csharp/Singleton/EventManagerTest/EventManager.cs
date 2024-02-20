using System.Globalization;
using CsvHelper;

public sealed class EventManager
{
    private static readonly EventManager INSTANCE = new EventManager();

    private EventManager()
    {
        this._events = new List<Event>();
    }

    public static EventManager Instance
    {
        get => INSTANCE;
    }

    private List<Event> _events;
    public List<Event> Events
    {
        get => this._events.ToList();
    }

    public bool AddEvent(Event e)
    {
        this._events.Add(e);
        return true;
    }

    public string EventsPath { get; set; }

    public bool ReadEvents()
    {
        if (string.IsNullOrEmpty(this.EventsPath))
        {
            Console.Error.WriteLine("No events file path");
            return false;
        }

        var eventsFile = new FileInfo(this.EventsPath);
        if (!eventsFile.Exists)
        {
            Console.Error.WriteLine($"Event file {this.EventsPath} not found");
            return false;
        }

        this._events.Clear();  // remove any old events before reading
        // NOTE: If the CSV reading fails, you may end up with an empty
        // or incomplete list. Maybe it would be better to read into a 
        // temporary list first, then clear the old list and copy the
        // new ones over only if the read is successful.

        using (var reader = new StreamReader(EventsPath))
        using (var csv = new CsvReader(reader, CultureInfo.InvariantCulture))
        {
            csv.Read();
            csv.ReadHeader();
            while (csv.Read())
            {
                var dateField = csv.GetField("date");
                DateOnly date;
                if (!DateOnly.TryParse(dateField, out date))
                {
                    Console.Error.WriteLine($"bad date: {dateField}, ignoring event");
                    continue;
                }

                var descriptionField = csv.GetField("description");

                var categoryField = csv.GetField("category");
                var categoryParts = categoryField.Split("/");
                var primary = categoryParts[0];
                var secondary = string.Empty;
                if (categoryParts.Length > 1)
                {
                    secondary = categoryParts[1];
                }

                var e = new Event(
                    date,
                    new Description(descriptionField),
                    new Category(primary, secondary)
                );

                this._events.Add(e);
            }
        }

        return true;
    }
}
