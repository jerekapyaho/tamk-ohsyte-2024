var eventManager = EventManager.Instance;

eventManager.EventsPath = "events.csv";

if (!eventManager.ReadEvents())
{
    Console.Error.WriteLine("Unable to read events, exiting");
    Environment.Exit(0);
}

//
// Simple LINQ query
//

var ms_events =
    from e in eventManager.Events
    where e.Category.Primary.Equals("microsoft")
    select e;

Console.WriteLine("\nAll Microsoft events:");
foreach (var e in ms_events)
{
    Console.WriteLine(e);
}

//
// LINQ query with filtering and ordering
//

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

var month = 11;
var day = 8;
DateOnly d = new DateOnly(2024, month, day);

//
// LINQ-to-objects query using fluent syntax
//

var dayQuery = eventManager.Events
    .Where(e => e.Date.Month == d.Month && e.Date.Day == d.Day)
    .OrderBy(e => e.Date)
    .Select(e => $"{e.Date.Year}: {e.Description}");

Console.WriteLine($"\nEvents on YYYY-{month:D02}-{day:D02}");
foreach (var e in dayQuery)
{
    Console.WriteLine(e);
}
