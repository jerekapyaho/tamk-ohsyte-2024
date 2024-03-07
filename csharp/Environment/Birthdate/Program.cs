
var birthdateValue = Environment.GetEnvironmentVariable("BIRTHDATE");
if (!string.IsNullOrEmpty(birthdateValue))
{
    try
    {
        var birthdate = DateOnly.Parse(birthdateValue);
        var today = DateTime.Now;

        if (today.Day == birthdate.Day && today.Month == birthdate.Month)
        {
            Console.WriteLine("Happy birthday!");
        }
    }
    catch (FormatException fe)
    {
        Console.WriteLine("Bad value in BIRTHDATE environment variable");
    }
}
