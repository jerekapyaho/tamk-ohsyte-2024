public class Day extends IntRange {
    private static final int MINIMUM_DAY = 1;
    private static final int MAXIMUM_DAY = 31;
    private static final int DEFAULT_DAY = 1;

    public Day() {
        this(Day.DEFAULT_DAY);
    }

    public Day(int day) {
        super(
            Day.MINIMUM_DAY, 
            Day.MAXIMUM_DAY, 
            Day.DEFAULT_DAY, 
            day
        );
    }
}
