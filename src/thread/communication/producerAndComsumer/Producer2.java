package thread.communication.producerAndComsumer;

import java.sql.Timestamp;

public class Producer2 {


    private String lock;

    public Producer2(String lock) {
        this.lock = lock;
    }

    public void cook() {

        synchronized (lock) {
            try {

                if (ValueObject.good.equals("")) {
                    ValueObject.good = new Timestamp(System.currentTimeMillis()).toString();
                    System.out.println("producer produce the good " + ValueObject.good);
                    lock.notify();
                } else {
                    lock.wait();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
