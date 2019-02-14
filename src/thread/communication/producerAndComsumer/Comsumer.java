package thread.communication.producerAndComsumer;

public class Comsumer {

    private String lock;

    public Comsumer(String lock) {
        this.lock = lock;
    }

    public void resume() {
        synchronized (lock) {
            try {
                if (!ValueObject.good.equals("")) {
                    ValueObject.good = "";
                    System.out.println("consumer get the good");
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
