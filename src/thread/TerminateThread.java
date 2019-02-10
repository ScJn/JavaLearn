package thread;

public class TerminateThread implements Runnable{

    private boolean flag=true;
    @Override
    public void run() {
        while (flag){
            System.out.println("run...");
        }
    }
    public void terminate(){
        flag=false;
    }

    public static void main(String[] args) throws InterruptedException {
        TerminateThread terminateThread=new TerminateThread();
        new Thread(terminateThread).start();
        for (int i=0;i<10;i++){
            Thread.sleep(100);
            if(i==9)terminateThread.terminate();
        }
    }
}
