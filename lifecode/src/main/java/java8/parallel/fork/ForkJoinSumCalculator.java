package java8.parallel.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private static final int THRESHOLD = 10_000;
    private final long[] a;
    private int start;
    private int end;
    public static ForkJoinPool forkJoinPool = new ForkJoinPool();

    public static void main(String[] args) {

//        long[] longs = LongStream.rangeClosed(0, 100000000).toArray();
//        ForkJoinSumCalculator forkJoinSumCalculator = new ForkJoinSumCalculator(longs);
//
//        TimeUtils.calculateAverageOf10(() ->  forkJoinPool.invoke(forkJoinSumCalculator));
//        TimeUtils.calculateMinOf10(() -> forkJoinPool.invoke(forkJoinSumCalculator));
//
//        TimeUtils.calculateAverageOf10(() -> calSum(100000000));
//        TimeUtils.calculateMinOf10(() -> calSum(100000000));
//        System.out.println("****"); // warm up
//        TimeUtils.calculateAverageOf10(() ->  forkJoinPool.invoke(forkJoinSumCalculator));
//        TimeUtils.calculateAverageOf10(() -> calSum(100000000));



    }

    static long calSum(int n){
        long sum = 0;
        for (long i = 1; i < n; i++) {
            sum += i;
        }
        return sum;
    }
    public ForkJoinSumCalculator(long[] a, int start, int end) {
        this.a = a;
        this.start = start;
        this.end = end;
    }

    public ForkJoinSumCalculator(long[] a) {
        this(a, 0, a.length);
    }

    @Override
    protected Long compute() {

        int length = end - start;
        if(length <= THRESHOLD){
            return computeSequentially();
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(a, start, start + length / 2);
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(a, start + length / 2 , end);

        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;

    }

    private Long computeSequentially() {
        long res = 0L;
        for(int i = start; i < end; i++){
            res += a[i];
        }
        return res;
    }
}
