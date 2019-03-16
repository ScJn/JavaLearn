package DataStructure;


import java.util.Comparator;

public class MyHeap<E>{

    private final Comparator<? super E> comparator;


    public MyHeap(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }


}
