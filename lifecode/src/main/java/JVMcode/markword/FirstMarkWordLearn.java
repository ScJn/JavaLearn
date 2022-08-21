package JVMcode.markword;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

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
 * @since 2022/8/6 9:26 下午
 * <p>
 * Copyright 2020 (C) <Alibaba Global>
 */
public class FirstMarkWordLearn {
    static A a;

    public static void main(String[] args) {
        a = new A();
        //Print the details of the JVM
        System.out.println(VM.current().details());
        //Print the corresponding object header information
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
