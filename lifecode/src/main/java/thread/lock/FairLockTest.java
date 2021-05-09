package thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * use fair lock to accomplish the orderly running thread
 */
public class FairLockTest {

    public static void main(String[] args) {

        // true is the core code
        Lock lock=new ReentrantLock(true);
        Condition c=lock.newCondition();
        Service2 s1=new Service2(lock,c);
        Service2 s2=new Service2(lock,c);
        Service2 s3=new Service2(lock,c);

        new Thread(s1).start();
        new Thread(s2).start();
        new Thread(s3).start();
    }
}

class Service2 implements Runnable{

    Lock lock;
    Condition condition;


    public Service2(Lock lock,Condition condition) {
        this.condition=condition;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true)work(condition);
    }

    private void work(Condition condition){
        lock.lock();
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName());
            condition.signalAll();
            condition.await();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}
