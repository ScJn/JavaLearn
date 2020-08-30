package java8.lambda;

import java.util.function.Consumer;

public class Diff {

    public void testThis(){
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("anonymous this: " + this);
            }
        };
        Consumer<String> c2= (a) -> System.out.println("lambda this: " + this);
        c.accept("1");
        c2.accept("2");
    }

    private void run(){
        Runnable runnable = () -> System.out.println(this);
        runnable.run();
    }

    public static void main(String[] args) {
//        new Diff().testThis();

        int a = 10;
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                int a = 3;
                System.out.println(3);
                System.out.println(this);
            }
        };

        Runnable runnable = () -> {
//            int a = 3; can not do this 
            System.out.println(a);
        };

        runnable1.run();

    }

}
