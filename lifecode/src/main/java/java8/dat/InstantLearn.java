package java8.dat;

import java.time.Instant;

public class InstantLearn {

    public static void main(String[] args) {

        Instant now = Instant.now();
        System.out.println(now);
    }

    private static void of() {
        Instant instant = Instant.ofEpochSecond(100);
        System.out.println(instant);
    }
}
