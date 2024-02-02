import java.time.LocalDate;

public class Event {
    public Event(LocalDate date, Description description, Category category) {
        this.date = date;
        this.description = description;
        this.category = category;
    }

    private LocalDate date;
    private Description description;
    private Category category;

    public LocalDate getDate() {
        return date;
    }

    public Description getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format(
            "%s %s (%s)", 
            this.date, 
            this.description.getValue(),
            this.category.getValue());
    }
}
