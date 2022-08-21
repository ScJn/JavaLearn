package JVMcode.markword;

import org.openjdk.jol.info.ClassLayout;

import static java.lang.System.out;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, situations that this interface is called, etc.]
 *
 * @author shikamaru
 * @see [String]
 * @see [Document URL]
 * @see [Class name#method name]
 * @since 2022/8/6 11:15 下午
 * <p>
 * Copyright 2020 (C) <Alibaba Global>
 */
public class HeavyLock {
    static A a;

    public static void main(String[] args) throws InterruptedException {
        a = new A();
        out.println("before lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());

        Thread t1 = new Thread(()->{
            synchronized (a) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                out.println("t1 release");
            }
        });
        t1.start();

        Thread.sleep(1000);
        out.println("t1 lock ing");
        out.println(ClassLayout.parseInstance(a).toPrintable());

        sync();
        out.println("after lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());

        System.gc();
        out.println("after gc()");
        out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    private static void sync() {
        synchronized (a) {
            out.println("main lock ing");
            out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }
}
