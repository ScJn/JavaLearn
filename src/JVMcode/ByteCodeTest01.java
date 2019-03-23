package JVMcode;

import java.util.HashMap;

public class ByteCodeTest01 extends HashMap {
    public int a;
    private int abcd;
    HashMap hash = new HashMap();
    public static void main(String[] args) {

        int c = 5;
        ByteCodeTest01 test01  = new ByteCodeTest01();

        System.out.println(test01.get(c));
    }

    public Integer get(int i){
        return i + ByteCodeTest02.a;
    }

}
