
type Event =
    { Description : string
      Category : string
      Date : System.DateOnly }

let events = [ 
    { Description = ".NET 8 released"
      Category = "microsoft/dotnet"
      Date = System.DateOnly(2023, 11, 14) }

    { Description = "macOS 14 Sonoma released"
      Category = "apple/macos"
      Date = System.DateOnly(2023, 09, 26) }

    { Description = "Java SE 21 released"
      Category = "java"
      Date = System.DateOnly(2023, 09, 19) }
]

let isInMonth event month = event.Date.Month = month

printfn "events has %d elements" events.Length

let septemberEvents = events |> Seq.filter (fun e -> isInMonth e 9)

printfn "\nEvents in September:"
for event in septemberEvents do
    printfn "%s" event.Description
