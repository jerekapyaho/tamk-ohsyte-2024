public class Year extends IntRange {
    private static final int MINIMUM_YEAR = 1900;
    private static final int MAXIMUM_YEAR = 2100;
    private static final int DEFAULT_YEAR = 2000;

    public Year() {
        this(Year.DEFAULT_YEAR);
    }

    public Year(int year) {
        super(
            Year.MINIMUM_YEAR, 
            Year.MAXIMUM_YEAR, 
            Year.DEFAULT_YEAR, 
            year
        );
    }
}
