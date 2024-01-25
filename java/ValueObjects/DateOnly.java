public class DateOnly {
    private Year year;
    private Month month;
    private Day day;

    public DateOnly() {
        this.year = new Year();
        this.month = new Month();
        this.day = new Day();
    }

    public DateOnly(int year, int month, int day) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public int getYear() {
        return this.year.getValue();
    }

    public void setYear(int year) {
        this.year = new Year(year); 
    }

    public int getMonth() {
        return this.month.getValue();
    }

    public void setMonth(int month) {
        this.month = new Month(month);
    }

    public int getDay() {
        return this.day.getValue();
    }

    public void setDay(int day) {
        int count = daysInMonth();
        if (day < 1 || day > count) {
            throw new IllegalArgumentException(
                String.format("Day must be 1...%d", count)
            );
        }
        
        this.day = new Day(day);
    }

    private int daysInMonth() {
        int result = 31;

        switch (month.getValue()) {
        case 2:
            result = 28;
            if (isLeapYear()) {
                result += 1;
            }
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            result = 30;
            break;
        default:
            break;
        }

        return result;
    }

    private boolean isLeapYear() {
        int y = this.year.getValue();
        return (y % 4 == 0) && (y % 100 != 0 || y % 400 == 0);
    }

    @Override
    public String toString() {
        int y = this.year.getValue();
        int m = this.month.getValue();
        int d = this.day.getValue();
        return String.format("%04d-%02d-%02d", y, m, d);
    }
}
