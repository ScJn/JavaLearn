package thread.communication;

public class Service {


    public void test(Object lock, String flag) {

        while (true) {
            synchronized (lock) {

                System.out.println(Thread.currentThread().getName() + " running!!!");
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void test2(Object lock, Integer flag) {

        String name = Thread.currentThread().getName();
        while (true) {
//            System.out.println(name + " before the syn");
            synchronized (lock) {

                if (flag.equals(Integer.parseInt(name))) {
                    flag = (1 + Integer.parseInt(name)) % 2;
                    System.out.println(Thread.currentThread().getName() + " running!!!");
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
//            System.out.println(name + " end the syn");

        }

    }

    synchronized void waitTest() {

        System.out.println("before wait");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after wait");

    }

    synchronized void notifyTest() {
        System.out.println("before notify");

        notify();

        System.out.println("after notify");
    }
}

class Thread1 implements Runnable {

    Service service;

    public Thread1(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.waitTest();
    }
}

class Thread2 implements Runnable {

    Service service;

    public Thread2(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.notifyTest();
    }
}

class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Thread t1 = new Thread(new Thread1(service));
        Thread t2 = new Thread(new Thread2(service));
        t1.start();
        t2.start();

    }
}

