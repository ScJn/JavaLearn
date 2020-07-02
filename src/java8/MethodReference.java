package java8;

import basic.runtimeTypeInfo.HiddenImpl.A;

import java.util.*;
import java.util.function.Function;

/**
 * @author scjn
 * @date 2020/6/24 18:16
 */
public class MethodReference {

    static class Apple implements Comparable<Apple> {
        int size;
        int weight;

        public Apple(int size, int weight) {
            this.size = size;
            this.weight = weight;
        }

        @Override
        public int compareTo(Apple o) {
            if (o.size - this.size != 0)
                return o.size - this.size;
            return o.weight - this.weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "size=" + size +
                    ", weight=" + weight +
                    '}';
        }

        public static <T, E> List<T> map(List<E> oList, Function<E, T> func) {
            ArrayList<T> res = new ArrayList<>();
            for (E e : oList) {
                T t = func.apply(e);
                res.add(t);
            }
            return res;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    public void test(){
        List<Banana> bananas = new ArrayList<>();
        bananas.add(new Banana(1,2));
        bananas.add(new Banana(2,2));
        bananas.add(new Banana(0,2));


        bananas.sort(Comparator.comparingInt((Banana a) -> a.size));
        bananas.sort((Banana a, Banana b) -> a.size - b.size);
    }


    public static void main(String[] args) {

        Apple apple = new Apple(1, 2);
        Apple apple1 = new Apple(1, 3);
        Apple apple2 = new Apple(2, 2);

        List<Apple> list = Arrays.asList(apple, apple1, apple2);
//        Collections.sort(list);

        list.sort(null);
        System.out.println(list);

        List<String> map = Apple.map(list, Apple::toString);


        Banana b1 = new Banana(1,2);
        Banana b2 = new Banana(2,2);
        Banana b3 = new Banana(1,3);
        list.sort(Comparator.comparing(Apple::getWeight).reversed());
        List<Banana> listb = Arrays.asList(b3, b1, b2);

        listb.sort(Comparator.comparing(Banana::getSize).reversed()
                .thenComparing(Banana::getWeight));




    }
}
