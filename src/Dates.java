import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;

public class Dates {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate xmas = LocalDate.of(2019, Month.DECEMBER, 25);

        Period period = Period.between(today, xmas);

        System.out.println(String.format("\n%s months and %s days to xmas", period.getMonths(), period.getDays()));

        LocalDateTime now = LocalDateTime.now();
        System.out.println(String.format("\nNow: %s", now));
    }
}
