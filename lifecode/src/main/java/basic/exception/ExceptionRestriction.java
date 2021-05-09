package basic.exception;

public class ExceptionRestriction {

    void f(){
        System.out.println(1);
    }

    static class ExceptionTest2 extends ExceptionRestriction{
        @Override
        void f() {
            super.f();
        }
    }
}
