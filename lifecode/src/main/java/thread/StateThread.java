package thread;

public class StateThread implements Runnable{


    @Override
    public void run() {

        for (int i=0;i<5;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run...");
            if(i==2){
                System.out.println("yield...");
                Thread.yield();
            }
            if(i==3&&Thread.currentThread().getName().equals("a1")){


            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        StateThread a=new StateThread();

        Thread thread=new Thread(a,"a1");
        Thread thread1=new Thread(a,"a2");
        thread1.start();
        printState(thread);
        thread.start();
        thread1.join();
        printState(thread);
        while(thread.getState()!=Thread.State.TERMINATED){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printState(thread);

        }

    }
    private static void printState(Thread thread){
        System.out.println(thread.getState());

    }
}
