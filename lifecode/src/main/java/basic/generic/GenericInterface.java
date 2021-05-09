package basic.generic;

import java.util.ArrayList;
import java.util.Arrays;

public interface GenericInterface<T> {
    T get();

    <E> void print(E c);

    static class Impl<T> implements GenericInterface<Object>{

        @Override
        public Object get() {
            return new Object();
        }

        @Override
        public <E> void print(E c) {
            System.out.println(c);
        }

        public static void main(String[] args) {
            Impl<System> impl  = new Impl<System>();
            impl.print(new ArrayList<>());
            Object o = impl.get();
            System.out.println(Arrays.toString(impl.getClass().getTypeParameters()));
            System.out.println(impl.getClass().getTypeName());
        }
    }
}
