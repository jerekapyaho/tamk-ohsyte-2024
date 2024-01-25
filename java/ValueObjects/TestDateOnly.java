public class TestDateOnly {
    public static void main(String[] args) {

        DateOnly d = new DateOnly(2024, 1, 18);
        
        System.out.println("d.year = " + d.getYear());
        
        try {
            d.setMonth(2);
            d.setDay(30);
        }
        catch (IllegalArgumentException iae) {
            System.err.println("Problem with DateOnly: " + iae.getMessage());
        }
        System.out.println(d);  // still has the original values

        //IntRange r = new IntRange(1, 10, 5, 1);
        // won't work because IntRange is an abstract class
    }
}
