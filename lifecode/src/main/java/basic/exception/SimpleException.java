package basic.exception;

public class SimpleException extends Exception {

    SimpleException(String msg){
        super(msg);
    }
    static class ExceptionTest{
        void f() throws SimpleException {
            throw new SimpleException("dddddddd");
        }
    }

    public static void main(String[] args) {

        ExceptionTest exceptionTest = new ExceptionTest();
        try {
            exceptionTest.f();
        } catch (SimpleException e) {
            e.printStackTrace();
            System.err.println("get simple exception");
        }
    }
}

