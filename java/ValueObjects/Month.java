public class Month extends IntRange {
    private static final int MINIMUM_MONTH = 1;
    private static final int MAXIMUM_MONTH = 12;
    private static final int DEFAULT_MONTH = 1;

    public Month() {
        this(Month.DEFAULT_MONTH);
    }

    public Month(int month) {
        super(
            Month.MINIMUM_MONTH, 
            Month.MAXIMUM_MONTH, 
            Month.DEFAULT_MONTH, 
            month
        );
    }
}
