using System.Globalization;
using CsvHelper;
using CsvHelper.Configuration;

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

        var config = new CsvConfiguration(CultureInfo.InvariantCulture)
        {
            HasHeaderRecord = true,
            PrepareHeaderForMatch = args => args.Header.ToLower()
        };

        using (var reader = new StreamReader(EventsPath))
        using (var csv = new CsvReader(reader, config))
        {
            csv.Context.RegisterClassMap<EventMap>();

            csv.Read();
            csv.ReadHeader();

            var allEvents = csv.GetRecords<Event>().ToList();
            foreach (var e in allEvents)
            {
                this._events.Add(e);
            }
        }

        return true;
    }
}
