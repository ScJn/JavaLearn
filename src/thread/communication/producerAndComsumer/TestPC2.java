package thread.communication.producerAndComsumer;

public class TestPC2 {

    public static void main(String[] args) {

        String lock=new String("");
        Producer2 p=new Producer2(lock);
        Comsumer c=new Comsumer(lock);
        Thread t1=new Thread(()->{
            while(true){
                p.cook();
            }
        });
        Thread t2=new Thread(()->{
            while(true){
                c.resume();
            }
        });
        t1.start();
        t2.start();
    }
}
