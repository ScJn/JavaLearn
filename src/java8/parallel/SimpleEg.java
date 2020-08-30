package java8.parallel;

import java8.stream.collect.PrimeNumberCollector;
import org.omg.CORBA.TIMEOUT;
import util.TimeUtils;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SimpleEg {

    public static void main(String[] args) {
//        testSequentialSum();

        TimeUtils.calculateMinOf10(() -> rangeSum(10000000));
        TimeUtils.calculateMinOf10(() -> iterSum(10000000));
        TimeUtils.calculateMinOf10(() -> parallelRangeSum(10000000));
        TimeUtils.calculateMinOf10(() -> parallelIterSum(10000000));


        TimeUtils.calculateAverageOf10(() -> rangeSum(10000000));
        TimeUtils.calculateAverageOf10(() -> iterSum(10000000));
        TimeUtils.calculateAverageOf10(() -> parallelRangeSum(10000000));
        TimeUtils.calculateAverageOf10(() -> parallelIterSum(10000000));

    }

    /**
     * works on primitive long numbers directly, there is no boxing and unboxing overhead
     * can be easily split into independent chunks
     * @param n
     * @return
     */
    public static long rangeSum(long n) {
        return LongStream.rangeClosed(0, n)
                .reduce(0L, Long::sum);
    }

    /**
     * iterate generates boxed objects, which have to be unboxed to numbers before they can be added
     * iterate is difficult to divide into chunks to execute in parallel
     *
     * @param n n
     * @return sum
     */
    public static long iterSum(long n) {
        return Stream.iterate(1L, i -> i + 1) //
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelRangeSum(long n) {
        return LongStream.rangeClosed(0, n)
                .parallel()
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelIterSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .parallel()
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static void testSequentialSum() {

        TimeUtils.printCosts(SimpleEg::iterSum, 10000L);
        TimeUtils.printCosts(() -> parallelIterSum(10000));
        TimeUtils.printCosts(() -> parallelRangeSum(10000));

        long sum = 0;
        long l1 = System.nanoTime();
        for (int i = 1; i <= 10000; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(System.nanoTime() - l1);
    }
}
