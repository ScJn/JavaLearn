package thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCondition {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static Condition condition2 = lock.newCondition();


    static ServiceForCondition service = new ServiceForCondition();

    public static void main(String[] args) throws InterruptedException {

        Object o = new Object();
        Thread t1 = new Thread(() -> {
            while (true) {
                service.set();
            }

        });
        Thread t2 = new Thread(() -> {
            while (true) {

                service.get();
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                service.put();
            }
        });
        t1.start();
        t3.start();
        t2.start();


    }


}

class ServiceForCondition {
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    boolean is1Lock = false;
    Condition condition2 = lock.newCondition();
    boolean is2Lock = false;
    int hasGood = 0;

    public void await1() {

        lock.lock();
        try {
            is1Lock = true;
            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal1() {
        lock.lock();
//        System.out.println("signal");
        condition1.signalAll();
        is1Lock = false;
        lock.unlock();
    }


    /**
     * extended ps patten, implements three thread running sequentially
     */
    public void set() {
        lock.lock();
        try {
            if (hasGood != 0) {
                condition1.await();
            }
            hasGood = 1;
            System.out.println("create good");
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        lock.lock();
        try {
            if (hasGood != 2) {
                condition1.await();
            }
            hasGood = 0;
            System.out.println("get good");
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void put() {
        lock.lock();
        try {
            if (hasGood != 1) {
                condition1.await();
            }
            hasGood = 2;
            System.out.println("put good");
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

//    public void await2() {
//
//        lock.lock();
//        try {
//            is2Lock=true;
//            condition2.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void signal2() {
//        lock.lock();
////        System.out.println("signal");
//        condition2.signalAll();
//        is2Lock=false;
//        lock.unlock();
//    }


}


