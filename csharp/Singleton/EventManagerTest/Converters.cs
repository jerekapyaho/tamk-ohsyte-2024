using CsvHelper;
using CsvHelper.TypeConversion;
using CsvHelper.Configuration;

//
// Type converters for CsvHelper
//

public class CategoryConverter<T> : DefaultTypeConverter
{
    public override object ConvertFromString(
        string text, 
        IReaderRow row, 
        MemberMapData memberMapData)
    {
        var categoryParts = text.Split("/");
        var primary = categoryParts[0];
        var secondary = string.Empty;
        if (categoryParts.Length > 1)
        {
            secondary = categoryParts[1];
        }        
        
        return new Category(primary, secondary);
    }

    public override string ConvertToString(
        object value, 
        IWriterRow row, 
        MemberMapData memberMapData)
    {
        var category = value as Category;

        return category.ToString();
    }
}

public class DescriptionConverter<T> : DefaultTypeConverter
{
public override object ConvertFromString(
        string text, 
        IReaderRow row, 
        MemberMapData memberMapData)
    {
        return new Description(text);
    }

    public override string ConvertToString(
        object value, 
        IWriterRow row, 
        MemberMapData memberMapData)
    {
        return value.ToString();
    }
}

//
// Mapper from CSV to Event, used by CsvHelper
//

public class EventMap : ClassMap<Event>
{
    public EventMap()
    {
        Map(m => m.Date);
        Map(m => m.Description).TypeConverter<DescriptionConverter<Description>>();
        Map(m => m.Category).TypeConverter<CategoryConverter<Category>>();
    }
}
