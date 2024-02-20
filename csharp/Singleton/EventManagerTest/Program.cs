var eventManager = EventManager.Instance;

eventManager.EventsPath = "events.csv";

if (eventManager.ReadEvents())
{
    foreach (var e in eventManager.Events)
    {
        Console.WriteLine(e);
    }
}
