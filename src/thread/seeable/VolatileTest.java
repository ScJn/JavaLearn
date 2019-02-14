package thread.seeable;

public class VolatileTest implements Runnable {

    volatile public static int count;

    private synchronized static void add() {
        for (int i = 0; i < 10; i++) {
            int c=count;
            c=c+1;
            count=c;
        }
    }

    @Override
    public void run() {
        add();
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<100;i++){
            new Thread(new VolatileTest()).start();
        }
        Thread.sleep(1000*10);
        System.out.println(count);
    }
}
