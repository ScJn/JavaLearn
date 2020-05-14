package basic.runtimeTypeInfo.HiddenImpl;

public class B implements A {
    @Override
    public void f() {
        System.out.println("b f()");
    }

    public void b(){
        System.out.println("b b()");
    }

    public static void main(String[] args) {
        A a = new B();
        a.f();
        if (a instanceof B) {
            ((B) a).b();
        }
    }
}
