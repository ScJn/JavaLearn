package thread.communication.producerAndComsumer;

public class Comsumer {

    private String lock;

    public Comsumer(String lock) {
        this.lock = lock;
    }

    public Comsumer() {
    }

    public void resume() {
        synchronized (lock) {
            try {
                if (!ValueObject.good.equals("")) {
                    ValueObject.good = "";
                    System.out.println(Thread.currentThread().getName() + " consumer get the good");
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

    public void resume2() {
        synchronized (lock) {
            try {
                if (ValueObject.good2.size() == 1) {
                    ValueObject.good2.remove(0);
                    System.out.println(Thread.currentThread().getName() + " consumer get the good");
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
