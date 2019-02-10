package thread;

public class LambdaTest {

    static class Bench implements car {

        @Override
        public void run() {
            System.out.println("Bench run!!!");
        }
    }

    public static void main(String[] args) {

        class BYD implements car {

            @Override
            public void run() {
                System.out.println("BYD run!!!");
            }
        }
        // one
        car car1 = new BMW();
        car1.run();
        //two
        car car2 = new Bench();
        car2.run();
        //three
        car car3=new BYD();
        car3.run();
        //four
        car car4 = new car() {
            @Override
            public void run() {
                System.out.println("anonymity Car run!!!");
            }
        };
        car4.run();
        //five lambda: only allow one method so that compiler can cope with.
        car car5= () -> System.out.println("lambda Car run!!!");
        car5.run();
    }

}


interface car {
    void run();
}

class BMW implements car {

    @Override
    public void run() {
        System.out.println("bmw run!!!");
    }
}
