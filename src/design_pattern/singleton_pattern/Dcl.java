package design_pattern.singleton_pattern;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 单例模式，在多线程下，对外存在一个对象
 * 1.构造器私有化 避免外部new构造器
 * 2.提供私有的静态属性 存储对象地址
 * 3.提供公共的静态方法 获取属性
 * dcl DoubleCheckedLocking
 */
public class Dcl implements Serializable {
    //饿汉式 new
    private static volatile Dcl instance;//懒汉式,类的静态成员变量为本类

    /**
     *  avoid reflection break
     */
    private Dcl() {
        if(null!=instance)throw new RuntimeException();
    }


    /**
     * problem A(synchronized),new Object need cost some time, then more than two thread get into the statement
     * <p>
     * problem B(double check), if the instance already exist,
     * other thread do not need to wait for the synchronized(.class) to get instance one by one,
     * it should return directly and all thread can get instance concurrently.
     * <p>
     * problem C(volatile), 'new' will do three step
     * 1. create space
     * 2. initialize the object
     * 3. return the reference of the object
     * if the second step is slow, the third step may finish first,
     * so that the reference is null
     *
     * @return
     */
    public static Dcl getInstance() {
        if (instance != null) return instance;
        synchronized (Dcl.class) {
            if (instance == null) instance = new Dcl();
            return instance;
        }
    }


    // 反序列化时，如果有就直接调用这个方法，不需要在创建新的对象
    private Object readResolve() throws ObjectStreamException{
        return instance;
    }

    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println(Dcl.getInstance()));
        t.start();
        System.out.println(Dcl.getInstance());
    }
}

class Hungry {
    private static volatile Hungry instance = new Hungry();

    private Hungry() {

    }

    public static Hungry getInstance() {
//        if(instance!=null)return instance;
//        synchronized (Hungry.class){
//            if (instance==null){
//                instance=new Hungry();
//            }
//            return instance;
//        }
        return instance;
    }


}

class T{
    /**
     * by reflecting, break the singleton
     *
     */
    public static void main(String[] args) throws Exception {
        Dcl dcl=Dcl.getInstance();
        Dcl dcl1=Dcl.getInstance();

//        Class c=dcl.getClass();
//        Constructor constructor=c.getDeclaredConstructor(null);
//        constructor.setAccessible(true);
//        Dcl dcl1= (Dcl)constructor.newInstance();
//        System.out.println(dcl1.hashCode()+ " "+dcl.hashCode());


        ObjectOutputStream oout=new ObjectOutputStream(new FileOutputStream("d:/hjx/a.txt"));
        oout.writeObject(dcl);
        ObjectInputStream oin=new ObjectInputStream(new FileInputStream("d:/hjx/a.txt"));
        Dcl d2= (Dcl) oin.readObject();
        System.out.println(dcl.hashCode()+" "+dcl1.hashCode()+" "+d2.hashCode());

    }

    public static void main2(String[] args) {

    }
}