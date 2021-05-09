package basic.generic;

import com.sun.org.apache.xpath.internal.objects.XObject;

public class Erasure {

    static class A<T>{

        void creat(){
//             new T();
        }

        T creatUseInstance(Class<T> kind) throws IllegalAccessException, InstantiationException {
            return kind.newInstance();
        }
    }

    static class B<E>{

    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        A<Object> a = new A<>();
        A<Integer> as = new A<>();
        System.out.println(a);
        System.out.println(as);

        Object o = a.creatUseInstance(Object.class);
//        Integer integer = as.creatUseInstance(Integer.class); Integer has no non-arg constructor
    }
}
