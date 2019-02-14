package thread.seeable;

public class VolatileTest2 implements Runnable {

    private boolean flag=true;
    @Override
    public void run() {

        if(Thread.currentThread().getName().equals("b")){
            flag=false;
            return;
        }
        String any= "";
        while(flag){
            synchronized (any){

            }
        }
        System.out.println("already stop");
    }

    public void stop(){
        flag=false;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest2 v=new VolatileTest2();
        Thread t1=new Thread(v,"a");
        Thread t2=new Thread(v,"b");
        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}
