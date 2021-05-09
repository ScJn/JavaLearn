package basic;


class Base {
    static int a = printInit("init a", 3);
    int b;

    Base(int b) {
        this.b = printInit("init b", 4);
    }

    Base(){
        System.out.println("base()");
    }

    public static int printInit(String msg, int c) {
        System.out.println(msg);
        return c;
    }
}

public class ClassInit extends Base{

    int c;
    static int d = printInit("init d", 5);
    ClassInit(int c){
        this.c = c;
        System.out.println("classInit()");
    }

    public static void main(String[] args) {
        new ClassInit(4);
    }

}
