package thread.communication.local;

/**
 * set a value to current thread-A
 * you can get the value if the thread is thread-A
 */
public class TestThreadLocal {

    static ThreadLocal<String> local=new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("sda");
        Thread t1=new Thread(()->{
            System.out.println(local.get());
        });
        t1.start();


        Thread t2=new Thread(()->{
            local.set("sss");
            System.out.println(local.get());
        });
        t2.start();
    }
}

