package basic.collection;

import java.util.Iterator;

public class WhyIterator {

    protected int[] a = new int[]{1,23,4,5,5};

    static class CollectionTest extends WhyIterator{
        public Iterator<Integer> iterator(){
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
    }

    public static void main(String[] args) {

        CollectionTest test = new CollectionTest();

        Iterator<Integer> iterator = test.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

