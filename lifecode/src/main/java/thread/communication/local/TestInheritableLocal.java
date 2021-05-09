package thread.communication.local;

public class TestInheritableLocal {

    public static InheritableThreadLocal<String> local=new InheritableThreadLocal<>();

    static ThreadLocal<String> local2=new ThreadLocal<>();

    public static void main(String[] args) {

        local.set("t2");
        local2.set("tw2");
        Thread t1=new Thread(()-> System.out.println(local.get()));
        t1.start();

        Thread t2=new Thread(()-> System.out.println(local2.get()));
        t2.start();

    }


}
