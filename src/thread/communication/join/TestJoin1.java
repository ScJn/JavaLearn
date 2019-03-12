package thread.communication.join;

public class TestJoin1 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(()->{

            try {
                Thread.sleep(1000*2);
                System.out.println("finish ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t1.join();

        System.out.println("after t1");
    }
}
