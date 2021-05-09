package basic.collection;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 34, 5);

        ListIterator<Integer> iterator = integers.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
    }
}
