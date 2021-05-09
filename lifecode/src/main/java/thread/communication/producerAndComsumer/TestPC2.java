package thread.communication.producerAndComsumer;

public class TestPC2 {

    public static void main(String[] args) {

        String lock = new String("");
        Producer2 p = new Producer2(lock);
        Comsumer c = new Comsumer(lock);
        Thread t1 = new Thread(() -> {
            while (true) {
                p.cook();
            }
        }, "pro1");
        Thread t2 = new Thread(() -> {
            while (true) {
                c.resume();
            }
        }, "re1");
        t1.start();
        t2.start();


        Thread t3 = new Thread(() -> {
            while (true) {
                p.cook();
            }
        }, "pro2");
        Thread t4 = new Thread(() -> {
            while (true) {
                c.resume();
            }
        }, "re2");
        t3.start();
        t4.start();
    }
}

class Test3 {
    public static void main(String[] args) {
        String lock="lock";
        Producer2 p=new Producer2(lock);
        Comsumer c=new Comsumer(lock);

        Thread1 t1=new Thread1(p);
        Thread1 t11=new Thread1(p);
        Thread1 t12=new Thread1(p);
        Thread2 t2=new Thread2(c);
        Thread2 t21=new Thread2(c);
        Thread2 t22=new Thread2(c);

        new Thread(t1,"p1").start();
        new Thread(t11,"p11").start();
        new Thread(t12,"p12").start();
        new Thread(t2,"c1").start();
        new Thread(t21,"c11").start();
        new Thread(t22,"c12").start();
    }
}


class Thread1 implements Runnable {

    Producer2 producer2;

    public Thread1(Producer2 producer2) {
        this.producer2 = producer2;
    }

    @Override
    public void run() {
        while (true)
            producer2.cook2();
    }
}

class Thread2 implements Runnable {

    Comsumer comsumer;

    public Thread2(Comsumer comsumer) {
        this.comsumer = comsumer;
    }

    @Override
    public void run() {
        while (true)
            comsumer.resume2();
    }
}