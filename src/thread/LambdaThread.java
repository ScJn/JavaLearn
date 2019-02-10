package thread;

public class LambdaThread {

    public static void main(String[] args) {
        new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("xuexi");

            }

        }).start();
        new Thread(() -> {

            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("chifan");
            }
        }).start();
    }
}
