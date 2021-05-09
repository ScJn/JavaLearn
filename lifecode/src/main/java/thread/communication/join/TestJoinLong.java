package thread.communication.join;

public class TestJoinLong {


    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1");
        });
        t1.start();

        Thread t2=new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2");

        });

        t2.start();

        t1.join(1500);
        t2.join(400);
        System.out.println("main");


    }
}
