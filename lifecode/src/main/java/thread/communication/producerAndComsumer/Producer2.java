package thread.communication.producerAndComsumer;

import java.sql.Timestamp;

public class Producer2 {


    private String lock;

    public Producer2(String lock) {
        this.lock = lock;
    }

    public Producer2() {
    }

    public void cook() {

        synchronized (lock) {
            try {

                if (ValueObject.good.equals("")) {
                    ValueObject.good = new Timestamp(System.currentTimeMillis()).toString();
                    System.out.println(Thread.currentThread().getName() + " producer produce the good " + ValueObject.good);
                    lock.notify();
                } else {
                    System.out.println(Thread.currentThread().getName() + " waiting!");
                    lock.wait();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void cook2() {
        synchronized (lock) {
            try {

                if (ValueObject.good2.size() == 0) {
                    ValueObject.good2.add("good");
                    System.out.println(Thread.currentThread().getName() + " producer produce the good remain" + ValueObject.good2.size());
                    lock.notifyAll();
                } else {
                    System.out.println(Thread.currentThread().getName() + " waiting!");
                    lock.wait();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
