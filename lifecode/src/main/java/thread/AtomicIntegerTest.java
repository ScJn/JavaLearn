package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable{

    public static AtomicInteger count=new AtomicInteger(0);

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<100;i++){
            new Thread(new AtomicIntegerTest()).start();
        }
        Thread.sleep(1000*3);
        System.out.println(count);
    }
}
