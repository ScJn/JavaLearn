package basic.collection;

import java.util.Iterator;

public class IterableTest implements Iterable {

    int[] a = new int[]{1, 2, 3, 4};

    @Override
    public Iterator iterator() {
        return new Iterator<Integer>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < a.length;
            }

            @Override
            public Integer next() {
                return a[index++];
            }
        };
    }

    public static void main(String[] args) {
        IterableTest test = new IterableTest();
        for (Object a: test) System.out.println(a);
    }
}
