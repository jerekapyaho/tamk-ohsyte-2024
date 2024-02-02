import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TestLocalDate {
    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println(now);

        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(2012, 4, 15));
        dates.add(LocalDate.of(2016, 5, 30));
        dates.add(LocalDate.of(1998, 11, 14));

        Collections.sort(dates);

        for (LocalDate d : dates) {
            System.out.println(d);
        }

        List<String> names = new ArrayList<>();
        names.add("Steve");
        names.add("Bill");
        names.add("Mark");

        Collections.sort(names);
        for (String n : names) {
            System.out.println(n);
        }

/*        
        LocalDate eighties = LocalDate.of(1984, 6, 16);
        LocalDate nineties = LocalDate.of(1999, 12, 31);

        if (eighties.compareTo(nineties) < 0) {
            System.out.println("eighties was before nineties");
        }
        //System.out.println(eighties.compareTo(nineties));
        //System.out.println(nineties.compareTo(eighties));
*/

    }
}
