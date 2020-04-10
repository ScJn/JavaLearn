package thread.seeable;

public class VolatileTest implements Runnable {

//    public static int count;
    volatile public static int count;

    // problem
    private void add0() {
        for (int i = 0; i < 10; i++) {
            int c = count;
            c = c + 1;
            count = c;
        }
    }

    private synchronized void add1() {
        for (int i = 0; i < 10; i++) {
            int c = count;
            c = c + 1;
            count = c;
        }
    }

    /**
     * change among add0, add1
     */
    @Override
    public void run() {
        add1();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            new Thread(new VolatileTest()).start();
        }
        Thread.sleep(1000 * 10);
        System.out.println(count);
    }
}
