package basic.collection;

import java.util.*;

public class IteratorTest {

    static <T> void display(Collection<T> collection){
        for (T co:collection){
            System.out.println(co);
        }
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(44);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        display(set);

        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(1.23);
        arrayList.add(1.33);

        display(arrayList);
    }
}
