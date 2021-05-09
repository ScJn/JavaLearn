package java8.dat;

import java.time.ZoneId;
import java.util.TimeZone;

public class ZoneIdLearn {

    public static void main(String[] args) {
        ZoneId id = TimeZone.getDefault().toZoneId();
        System.out.println(id);
    }
}
