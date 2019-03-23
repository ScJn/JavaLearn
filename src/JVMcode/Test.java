package JVMcode;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> list=ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean b : list) System.out.println(b.getName());
        HashMap a;
        System.out.println("SADADASDASDAS");
    }

}
