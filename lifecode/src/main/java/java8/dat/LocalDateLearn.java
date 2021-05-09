package java8.dat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalDateLearn {

    public static void main(String[] args) {


        LocalDate d = LocalDate.parse("2020-11-11");
        LocalTime t = LocalTime.parse("12:12:12");
        LocalDateTime dateTime = LocalDateTime.of(d, t);
        System.out.println(dateTime);

    }

    private static void parse() {
        LocalDate.parse("2020-11-11");
        LocalTime.parse("12:12:12");
    }

    private static void now() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.get(ChronoField.DAY_OF_MONTH));

        LocalTime now2 = LocalTime.now();
        System.out.println(now2);
        System.out.println(now2.getHour());
    }

    private static void of() {
        LocalDate date = LocalDate.of(2020,11,15);
        System.out.println(date);
        System.out.println(date.getMonth());
    }
}
