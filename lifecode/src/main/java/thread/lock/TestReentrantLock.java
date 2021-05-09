package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {


    public static void main(String[] args) {

        ReentrantLock lock=new ReentrantLock();
        Thread1 t1=new Thread1(lock);
        Thread1 t2=new Thread1(lock);
        Thread1 t3=new Thread1(lock);

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();

    }
}

class Thread1 implements Runnable{


    Lock lock;

    public Thread1(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }
}
