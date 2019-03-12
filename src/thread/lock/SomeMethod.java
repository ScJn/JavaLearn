package thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SomeMethod {

    static ReentrantLock lock=new ReentrantLock();
    static Condition c1=lock.newCondition();
    static Condition c2=lock.newCondition();
    static Condition c3=lock.newCondition();

    static void lockOne() throws InterruptedException {
        lock.lock();
        Thread.sleep(1000);
        System.out.println("holdCount "+lock.getHoldCount());
        System.out.println("queueLength: "+lock.getQueueLength());
        System.out.println("waitQueueLength: "+lock.getWaitQueueLength(c1));

        lock.unlock();
    }

    static void lockTwo(){
        lock.lock();
        try {
            lockOne();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("holdCount "+lock.getHoldCount());
        System.out.println("queueLength: "+lock.getQueueLength());
        System.out.println("waitQueueLength: "+lock.getWaitQueueLength(c1));

        lock.unlock();
    }

    static void wait1() throws InterruptedException {

        lock.lock();
        c1.await();
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {


        Thread t1=new Thread(()->{
            try {
                wait1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2=new Thread(SomeMethod::lockTwo);
        Thread t3=new Thread(SomeMethod::lockTwo);


        t1.start();t2.start();t3.start();
    }
}
