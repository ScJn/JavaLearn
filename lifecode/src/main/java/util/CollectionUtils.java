package util;

import java.util.Collection;
import java.util.function.Supplier;

public class CollectionUtils {

    public static <E> Collection<E> adds(Collection<E> o, int size, Supplier<E> supplier){
        for (int i = 0; i < size; i++) {
            o.add(supplier.get());
        }
        return o;
    }
}
