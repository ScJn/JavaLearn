package thread.communication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComTest1 implements Runnable {

    Object obj;
    Integer i = 0;

    public ComTest1(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.test2(obj, i);
    }

    public static void main(String[] args) throws InterruptedException {

//        Object o = new Object();
//        ComTest1 c = new ComTest1(o);
//        Thread t1 = new Thread(c,"0");
//        Thread t2 = new Thread(c,"1");
//        Thread t3 = new Thread(c,"2");
//
//        t1.start();
//        Thread.sleep(2000);
//        t2.start();
//        Thread.sleep(2000);
//        t3.start();

        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("1");

            }
        });

        Thread t2 = new Thread(() -> {
            while (true)
                System.out.println("2");
        });

        Thread t3 = new Thread(() -> {
            while (true)
                System.out.println("3");
        });
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);
    }
}
