package thread;

public class SynTest {
    static class Web12306 implements Runnable {
        int num;
        boolean flag;

        @Override
        public void run() {
            while (flag) {
                test3();
            }
        }

        public Web12306(int num) {
            this.num = num;
            flag = true;
        }

        private void test() {
            if (num >= 1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num--;
                System.out.println(Thread.currentThread().getName() + " get one remain num->" + num);
            } else {
                flag = false;
            }
        }

        // synchronized method, is not efficient
        synchronized void test1() {
            test();
        }

        //the Integer object will change
        void test2() {
            synchronized ((Integer) num) {
                test();
            }
        }

        //double check
        void test3() {
            if (num < 1) {
                flag = false;
            } else {
                synchronized (this) {
                    test();
                }
            }
        }

    }

    public static void main(String[] args) {
        Web12306 w1 = new Web12306(10);
        Thread t1 = new Thread(w1, "man1");
        Thread t2 = new Thread(w1, "man2");
        Thread t3 = new Thread(w1, "man3");
        t1.start();
        t3.start();
        t2.start();
    }
}
