package thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReLock {
    private boolean isLocked = false;
    private Thread nowThread;
    int count = 0;

    public  void lock() throws InterruptedException {

        while (isLocked && Thread.currentThread() != nowThread) {
            wait();
        }
        isLocked = true;
        count++;
        nowThread = Thread.currentThread();
    }

    public  void unLock() {
        isLocked = false;
        nowThread = null;
        count = 0;
    }
}

class Test1 {
    private ReLock reLock = new ReLock();
    private ReentrantLock lock = new ReentrantLock();

    public void doA() throws InterruptedException {
        reLock.lock();
        System.out.println("in doA " + reLock.count);
        doB();
        reLock.unLock();
    }

    public void doB() throws InterruptedException {
        reLock.lock();
        System.out.println("in doB " + reLock.count);
        reLock.unLock();

        Thread.sleep(1000);
        System.out.println(reLock.count);
    }

    public static void main(String[] args) throws InterruptedException {
        new Test1().doA();


    }
}
