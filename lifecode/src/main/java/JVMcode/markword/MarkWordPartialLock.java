package JVMcode.markword;

import org.openjdk.jol.info.ClassLayout;

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
public class MarkWordPartialLock {

    static A a;

    public static void main(String[] args) throws InterruptedException {

        a = new A();
        out.println("before lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());

        sync();

        out.println("after lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());

    }

    private static void sync() {
        synchronized (a) {
            out.println("I don't know what to print");
        }
    }
}
