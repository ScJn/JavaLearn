package basic.keyword;

abstract public class AbstractTest {

    void fun1(){
        System.out.println("fun1");
    }
}

abstract class AbstractTest2{
    abstract void aFun();
}
class Some{

    public static void main(String[] args) {
        AbstractTest test = new AbstractTest(){};

        AbstractTest2 test2 = new AbstractTest2() {
            @Override
            void aFun() {
                System.out.println("afun");
            }
        };

        test.fun1();
        test2.aFun();

    }
}