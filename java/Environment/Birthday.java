import java.time.LocalDate;

public class Birthday {
    public static void main(String[] args) {
        String birthdateValue = System.getenv("BIRTHDATE");

        LocalDate birthdate = LocalDate.parse(birthdateValue);

        LocalDate today = LocalDate.now();

        if (isSameDate(today, birthdate)) {
            System.out.println("Happy birthday!");
        }
    }

    public static boolean isSameDate(LocalDate date1, LocalDate date2) {
        return date1.getDayOfMonth() == date2.getDayOfMonth() &&
            date1.getMonth() == date2.getMonth();
    }
}