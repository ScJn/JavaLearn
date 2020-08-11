package java8.stream.collect;

import java8.stream.Partition;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

    public static void main(String[] args) {
        long l = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            partitionPrimesWithCustomCollector(1_000_000);
        }
        System.out.println(System.nanoTime() - l);

        long l1 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            Partition.getAllPrime(1_000_000);
        }
        System.out.println(System.nanoTime() - l1);
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(new PrimeNumberCollector());
    }

    public static <A> List<A> takeWhile(List<A> sortedList, Predicate<A> predicate) {
        for (int i = 0; i < sortedList.size(); i++) {
            if (!predicate.test(sortedList.get(i))) {
                return sortedList.subList(0, i);
            }
        }
        return sortedList;
    }

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>() {{
            put(true, new ArrayList<>());
            put(false, new ArrayList<>());
        }};
    }

    private boolean isPrime(Integer candidate, List<Integer> prePrimes) {
        return takeWhile(prePrimes, a -> a <= (int) Math.sqrt(candidate))
                .stream()
                .noneMatch(prime -> candidate % prime == 0);
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (map, candidate) -> {
            if (isPrime(candidate, map.get(true))) {
                map.get(true).add(candidate);
            }
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (map, map2) -> {
            map.get(true).addAll(map2.get(true));
            map.get(false).addAll(map2.get(false));
            return map;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH)); // set.of(a), a's set, set includes a. create a set and add a.
    }


}
