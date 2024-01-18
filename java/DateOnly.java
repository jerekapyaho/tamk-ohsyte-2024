public class DateOnly {
    private int year;
    private int month;
    private int day;

    public DateOnly(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public static final int MIN_YEAR = 1900;
    public static final int MAX_YEAR = 2100;

    public void setYear(int year) {
        if (year < DateOnly.MIN_YEAR || year > DateOnly.MAX_YEAR) {
            throw new IllegalArgumentException(
                String.format("Year must be %d...%d", DateOnly.MIN_YEAR, DateOnly.MAX_YEAR));
        }

        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be 1...12");
        }

        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        int count = daysInMonth();
        if (day < 1 || day > count) {
            throw new IllegalArgumentException(String.format("Day must be 1...%d", count));
        }
        
        this.day = day;
    }

    private int daysInMonth() {
        int result = 31;

        switch (month) {
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
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
