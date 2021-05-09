package thread.lock;

/**
 * 不可重入锁
 */
public class NormalLock {
    private boolean isLocked = false;

    public void lock() throws InterruptedException {

        while (isLocked) {
            wait();
        }
        isLocked = true;

    }

    public void unlock() {
        isLocked = false;
        notify();
    }


}

class test {
    NormalLock lock = new NormalLock();

    private void doA() throws InterruptedException {
        lock.lock();
        System.out.println("in doA");
        doB();
        lock.unlock();
    }

    /**
     * invoked by doA(), invokes the lock recursively
     */
    private void doB() throws InterruptedException {
        lock.lock();
        System.out.println("in doB");
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        new test().doA();
    }
}