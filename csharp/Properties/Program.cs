using System.Collections.Generic;

Event e1 = new Event(new DateOnly(2023, 11, 14), ".NET 8 released", "microsoft");
//Console.WriteLine(e1);

// https://learn.microsoft.com/en-us/dotnet/standard/datetime/how-to-use-dateonly-timeonly

List<Event> events = new ();
events.Add(e1);

Event e2 = new Event(new DateOnly(2022, 11, 8), ".NET 7 released", "microsoft");
events.Add(e2);

events.Add(new Event(new DateOnly(2021, 11, 8), ".NET 6 released", "microsoft"));

foreach (Event e in events)
{
    Console.WriteLine(e);
}

events.Sort();  // impossible unless Event implements IComparable!
Console.WriteLine("\nSorted events:");
foreach (Event e in events)
{
    Console.WriteLine(e);
}
