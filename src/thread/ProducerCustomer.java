package thread;

public class ProducerCustomer {


    public static void main(String[] args) {

        Container con=new Container();
        Producer producer=new Producer(con);
        Customer customer=new Customer(con);
        new Thread(producer,"producer").start();
        new Thread(customer,"customer").start();
    }



}

//producer

class Producer implements Runnable{

    Container container;

    public Producer(Container con) {
        this.container = con;
    }

    @Override
    public  void run() {
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(100);
                container.push(new Good(i));
                System.out.println(Thread.currentThread().getName()+" 生成了第 "+i+"个good");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//Customer
class Customer implements Runnable{
    Container container;

    public Customer(Container con) {
        this.container = con;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+" 消费了第 "+container.pop().i+"个good");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//Container
class Container {
    Good[] goods = new Good[10];
    static final int MAX = 10;
    int size = 0;

    public Container(){

    }
    public synchronized void push(Good good) throws InterruptedException {
        if (size >= MAX) {
            wait();

        } else {
            goods[size++] = good;
            notifyAll();
        }
    }

    public synchronized Good pop() throws InterruptedException {
        if (size > 0) {
            Good good=goods[--size];
            goods[size]=null;
            notifyAll();
            return good;
        } else {
            wait();
        }return null;
    }
}

//Good
class Good {
    int i;

    public Good(int i) {
        this.i = i;
    }
}
