public class Description
{
    private string _value;

    public string Value
    {
        get => this._value;

        set
        {
            ArgumentNullException.ThrowIfNullOrEmpty(value);

            if (value.Length > 500)
            {
                throw new ArgumentException("Description is too long");
            }

            this._value = value;
        }
    }

    public Description(string description)
    {
        this.Value = description;
    }

    public override string ToString()
    {
        return this.Value;
    }
}

public class Category
{
    public string Primary { get; set; }
    public string Secondary { get; set; }

    public Category(string primary)
    {
        this.Primary = primary;
        this.Secondary = string.Empty;
    }

    public Category(string primary, string secondary)
    {
        this.Primary = primary;
        this.Secondary = secondary;
    }

    public override string ToString()
    {
        string result = this.Primary;
        if (!string.IsNullOrEmpty(this.Secondary))
        {
            result += "/" + this.Secondary;
        }
        return result;
    }
}

public class Event: IComparable {
    public Description Description { get; set; }
    public Category Category { get; set; }
    public DateOnly Date { get; set; }

    public Event(DateOnly date, Description description, Category category)
    {
        this.Date = date;
        this.Description = description;
        this.Category = category;
    }

    public override string ToString()
    {
        return $"{this.Date} {this.Description} ({this.Category})";
    }

    //
    // IComparable implementation
    //

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
