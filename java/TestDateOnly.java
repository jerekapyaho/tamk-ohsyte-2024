public class TestDateOnly {
    public static void main(String[] args) {
        DateOnly d = new DateOnly(2024, 1, 18);
        
        try {
            d.setMonth(2);
            d.setDay(30);
        }
        catch (IllegalArgumentException iae) {
            System.err.println("Problem with DateOnly: " + iae.getMessage());
        }
        System.out.println(d);
    }
}
