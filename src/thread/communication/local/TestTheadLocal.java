package thread.communication.local;

public class TestTheadLocal {

    static ThreadLocal<String> local=new ThreadLocal<>();

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            local.set("hhhh");
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

class Thread1 implements Runnable{



    @Override
    public void run() {

    }
}
