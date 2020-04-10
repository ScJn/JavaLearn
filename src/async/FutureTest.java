package async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author scjn
 * @date 2020/4/6 13:09
 */
public class FutureTest {


    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long b = System.currentTimeMillis();
        Future<String> s = executorService.submit(new Call());
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis() - b);
        System.out.println(s.get());
    }
}

class Call implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "world";
    }
}
