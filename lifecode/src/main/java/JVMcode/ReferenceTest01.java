package JVMcode;

import java.lang.ref.WeakReference;

public class ReferenceTest01 {

    public static void main(String[] args) {

        String a = "hello";
        WeakReference<String> weakA = new WeakReference<>(a);
        System.gc();
        System.out.println("A:" + weakA.get());

        String b = "hello";
        WeakReference<String> weakB = new WeakReference<>(b);
        b = null;
        System.gc();
        System.out.println(weakB.get());

        String c = new String("hello");
        WeakReference<String> weakC = new WeakReference<>(c);
        c = null;
        System.gc();
        System.out.println(weakC.get());

        String d = new String("hello");
        d = d.intern();
        WeakReference<String> weakD = new WeakReference<>(d);
        d = null;
        System.gc();
        System.out.println(weakD.get());

    }
}
