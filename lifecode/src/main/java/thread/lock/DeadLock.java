package thread.lock;

public class DeadLock {

    public static void main(String[] args) {


        class Soup {

        }
        class Fruit {

        }
        class Man extends Thread {
            int status;
            Soup soup;
            Fruit fruit;

            public Man(int status, Soup soup, Fruit fruit) {
                this.status = status;
                this.soup = soup;
                this.fruit = fruit;
            }

            @Override
            public void run() {
                if (status == 0) {
                    synchronized (soup) {
                        System.out.println(Thread.currentThread().getName() + " get soup");
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (fruit) {
                            System.out.println(Thread.currentThread().getName() + " get fruit");
                        }
                    }
                } else if (status == 1) {
                    synchronized (fruit) {
                        System.out.println(Thread.currentThread().getName() + " get fruit");
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (soup) {
                            System.out.println(Thread.currentThread().getName() + " get soup");

                        }
                    }
                }
            }
        }

        Soup soup=new Soup();
        Fruit fruit=new Fruit();
        new Man(1,soup,fruit).start();
        new Man(0,soup,fruit).start();
    }
}
