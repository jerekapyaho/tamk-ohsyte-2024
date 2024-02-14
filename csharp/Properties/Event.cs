public class Event: IComparable {

    // Private backing field, validation in getter and setter
    private string description;

    public string Description
    {
        get
        {
            return this.description;
        }
        
        set
        {
            // The incoming new value is always named `value`.

            ArgumentNullException.ThrowIfNullOrEmpty(value);

            if (value.Length > 500)
            {
                throw new ArgumentException("Description is too long");
            }

            this.description = value;
        }
    }

    private string category;

    public string Category
    {
        get => this.category;   // shorthand for simple getter

        set
        {
            ArgumentNullException.ThrowIfNullOrEmpty(value);

            if (value.Length > 50)
            {
                throw new ArgumentException("Category is too long");
            }

            this.category = value.ToLower();
        }
    }

    // Automatic property: direct access to private field
    public DateOnly Date { get; set; }

    public Event(DateOnly date, string description, string category)
    {
        this.Date = date;
        this.Description = description;
        this.Category = category;
    }

    public override string ToString()
    {
        return $"{this.Date} {this.Description} ({this.Category})";
    }

    // IComparable implementation

    public int CompareTo(object obj)
    {
        if (obj == null)
        {
            return 1;
        }

        Event otherEvent = obj as Event;
        if (otherEvent != null)
        {
            return this.Date.CompareTo(otherEvent.Date);
        }
        else
        {
            throw new ArgumentException("Object is not an Event");
        }
    }
}
