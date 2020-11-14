package util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TimeUtils {

    public static void delay() {
        try {
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static <T> T printCosts(Supplier<T> func) {
        long l = System.nanoTime();
//        System.out.println(func.get());
        T t = func.get();
        System.out.println((System.nanoTime() - l) / 10_000_000);
        return t;
    }

    public static <T, R> void printCosts(Function<T, R> func, T para) {
        long l = System.nanoTime();
        System.out.println(func.apply(para));
        System.out.println((System.nanoTime() - l) / 10_000_000);
    }

    public static <T> void calculateMinOf10(Supplier<T> func) {
        long cur = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long l = System.nanoTime();
            func.get();
            long duration = System.nanoTime() - l;
            if (duration < cur) {
                cur = duration;
            }
        }
        System.out.println("min of 10 is: " + cur);
    }

    public static <T> void calculateAverageOf10(Supplier<T> func) {
        long cur = 0;
        for (int i = 0; i < 10; i++) {
            long l = System.nanoTime();
            func.get();
            cur += System.nanoTime() - l;

        }
        System.out.println("average of 10 is: " + cur / 10);
    }

}
