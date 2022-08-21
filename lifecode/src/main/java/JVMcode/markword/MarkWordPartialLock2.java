package JVMcode.markword;

import org.openjdk.jol.info.ClassLayout;

import static java.lang.System.gc;
import static java.lang.System.out;

/**
 *
 * only one thread to call the sync method. It should be a partial lock.
 *
 *
 * @author shikamaru
 * @see [String]
 * @see [Document URL]
 * @see [Class name#method name]
 * @since 2022/8/6 10:08 下午
 * <p>
 * Copyright 2020 (C) <Alibaba Global>
 */
public class MarkWordPartialLock2 {

    static A a;

    public static void main(String[] args) throws InterruptedException {
        //Remember that the delay must be placed before the creation of the object, otherwise it is invalid, because before you create the object, you prefer the delay time of the lock
        //Without sleeping for you, the object has been created and the information of the object header has been generated.
        Thread.sleep(5000);
        a = new A();
        out.println("before lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());
        out.println(Integer.toHexString(a.hashCode()));

        sync();

        out.println("after lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());

        gc();
        out.println("gc...");
        out.println(ClassLayout.parseInstance(a).toPrintable());
        sync();

        out.println("after lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());



    }
    private static void sync() {
        synchronized (a) {
            out.println("thread Id: " + Thread.currentThread().getId());
            out.println("lock ing");
            out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }
}
