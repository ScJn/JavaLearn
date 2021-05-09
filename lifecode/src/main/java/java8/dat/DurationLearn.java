package java8.dat;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DurationLearn {


    public static void main(String[] args) {

        LocalDateTime d1 = LocalDateTime.now();
        LocalDateTime d2 = LocalDateTime.parse("2020-01-01T12:21:12");
        Instant i1 = Instant.now();
        Instant i2 = Instant.ofEpochSecond(10000000);
        System.out.println(Duration.between(d1, d2));
        System.out.println(Duration.between(i1, i2));
    }
}
