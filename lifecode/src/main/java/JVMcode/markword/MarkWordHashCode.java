package JVMcode.markword;

import org.openjdk.jol.info.ClassLayout;

import static java.lang.System.out;

/**
 *
 * hash code is at 4 - 7 B
 *
 * @author shikamaru
 * @see [String]
 * @see [Document URL]
 * @see [Class name#method name]
 * @since 2022/8/6 9:52 下午
 * <p>
 * Copyright 2020 (C) <Alibaba Global>
 */
public class MarkWordHashCode {
    public static void main(String[] args) {
        A a = new A();
        //The object header before HashCode is not evaluated
        out.println("before hash");
        out.println(ClassLayout.parseInstance(a).toPrintable());

        //Computing HashCode by jvm
        out.println("jvm----------" + Integer.toHexString(a.hashCode()));

        //After calculating the HashCode, we can see the information change of the object header
        out.println("after hash");
        out.println(ClassLayout.parseInstance(a).toPrintable());

    }
}
