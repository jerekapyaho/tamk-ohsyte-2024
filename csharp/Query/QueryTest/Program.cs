var eventManager = EventManager.Instance;

eventManager.EventsPath = "events.csv";

if (!eventManager.ReadEvents())
{
    Console.Error.WriteLine("Unable to read events, exiting");
    Environment.Exit(0);
}

var ms_events =
    from e in eventManager.Events
    where e.Category.Primary.Equals("microsoft")
    select e;

Console.WriteLine("\nAll Microsoft events:");
foreach (var e in ms_events)
{
    Console.WriteLine(e);
}

var macos_events =
    from e in eventManager.Events
    where e.Category.Primary.Equals("apple")
        && e.Category.Secondary.Equals("macos")
    orderby e.Date descending
    select $"{e.Date}: {e.Description}";

Console.WriteLine("\nAll macOS-related events:");
foreach (var e in macos_events)
{
    Console.WriteLine(e);
}

