package java8.stream.collect;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * supplier, accumulator and finisher would be enough,
 * but considering lazy nature and processing parallel, we need more
 *
 * @param <T>
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {
    /**
     * use constructor reference
     *
     * @return a new ArrayList
     */
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    /**
     * the accumulator method returns the function that performs the
     * reduction operation.
     * When traversing the nth element in the stream,
     * this function is applied with two arguments,
     * the accumulator being the result of the reduction(after having collected the first n-1 items)
     *
     * @return BiConsumer
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return (a, b) -> {
            a.add(b);
        };
    }

    /**
     * merge two result containers
     *
     * @return a merged container
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (a, b) -> {
            a.addAll(b);
            return a;
        };
    }


    /**
     * Applying the final transformation to the result
     *
     * @return function
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    /**
     * defining the behavior of the collector
     * providing hints about whether the stream
     * can be reduced in parallel and
     * which optimization are valid when doing so.
     * <p>
     * unordered: order make on sense
     * concurrent: accumulator method can be called concurrently
     * identity_finish: finisher is identity one
     *
     * @return an immutable set of Characteristics
     */
    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Collector.Characteristics.IDENTITY_FINISH);
    }

    public static void main(String[] args) {
        ToListCollector<Integer> integerToListCollector = new ToListCollector<>();

        Integer[] integers = {1, 2, 3, 4, 5, 2, 5};

        List<Integer> collect = Arrays.stream(integers).filter(integer -> integer % 2 == 0).collect(integerToListCollector);

        for (Integer integer : collect) {
            System.out.println(integer);
        }

        // only implements supplier, accumulator and combiner
        ArrayList<Object> collect1 = Arrays
                .stream(integers)
                .filter(integer -> integer % 2 == 0)
                .collect(ArrayList::new, List::add, List::addAll);



    }
}
