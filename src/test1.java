import leetcode.tree.TreeNode;

class Test {


    public static void main(String[] args) {
        Object lock = new Object();

        Thread thread = new Thread(() -> {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("lock out");
        });
        thread.start();

        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.notifyAll();

            System.out.println("notify lock out");
        });

        thread1.start();


    }
}