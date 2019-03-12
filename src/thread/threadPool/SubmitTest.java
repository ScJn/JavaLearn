package thread.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service=Executors.newFixedThreadPool(1);
        Future<String> future=service.submit(()->{
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            System.out.println("a");
            return Thread.currentThread().getName();
        });

        System.out.println(future);
        //is done?
        System.out.println(future.isDone());
        System.out.println(future.get());

    }
}
