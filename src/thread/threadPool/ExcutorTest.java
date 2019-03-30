package thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * test the ExecutorService
 */
public class ExcutorTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 4; i++) {
            int t = 0;
            service.execute(() -> {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }

            });
        }


    }

    static void testTe(ExecutorService service) throws InterruptedException {
        System.out.println(service);
        service.shutdown();
        //dead
        System.out.println(service.isTerminated());
        //terminated means the pool is closing, waiting the remained task finish.
        System.out.println(service.isShutdown());
        System.out.println(service);

        Thread.sleep(1000);
        System.out.println(service);
    }
}
