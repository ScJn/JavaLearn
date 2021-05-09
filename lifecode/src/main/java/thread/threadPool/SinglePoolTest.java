package thread.threadPool;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SinglePoolTest {

    public static void main(String[] args) {

        ExecutorService service=Executors.newSingleThreadExecutor();
        ExecutorService service2=Executors.newCachedThreadPool();

        service.submit(()-> {
            while(true)System.out.println("A");
        });
        service.submit(()-> {
            while(true)System.out.println("B");
        });
        service.submit(()-> {
            while(true)System.out.println("B");
        });
    }
}
